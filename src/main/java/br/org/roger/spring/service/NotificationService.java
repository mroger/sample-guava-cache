package br.org.roger.spring.service;

import br.org.roger.spring.I18nHelper;
import br.org.roger.spring.MtpUtils;
import br.org.roger.spring.dao.MessageTemplateDAO;
import br.org.roger.spring.domain.*;
import br.org.roger.spring.dto.MessageTemplateDTO;
import br.org.roger.spring.dto.PortalInfosDTO;
import br.org.roger.spring.dto.ProfileDTO;
import br.org.roger.spring.dto.TipoItemPagamentoEnum;
import br.org.roger.spring.exception.BadRequestException;
import br.org.roger.spring.exception.ResourceNotFoundException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.*;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class NotificationService {

    public static final int TRANSACAO_LANCE_VENCEDOR = 15;
    public static final int TRANSACAO_LANCE_CONDICIONAL_ACEITO = 26;

    public static final int TRANSACAO_COMPREJA_VENDA_GERADA = 108;
    public static final int TRANSACAO_PROPOSTA_VENDA_GERADA = 109;
    public static final int TRANSACAO_HIBRIDO_VENDA_GERADA = 110;

    //public static final int TRANSACAO_AGUARDAR_CONDICIONAL = 16;
    //public static final int TRANSACAO_CONDICIONAL_RECUSADO = 17;

    public static final int MODALIDADE_LEILAO = 1;
    public static final int MODALIDADE_LEILAO_JUDICIAL = 2;
    public static final int MODALIDADE_VENDA_DIRETA = 3;
    public static final int MODALIDADE_LEADS = 4;

    public static final long OFFER_TYPE_LEILAO_CONVENCIONAL = 1;
    public static final long OFFER_TYPE_COMPRE_JA = 8;
    public static final long OFFER_TYPE_PROPOSTA = 9;
    public static final long OFFER_TYPE_HIBRIDO = 10;

    private static final Logger log = Logger.getLogger(NotificationService.class);
    private static final Long GESTOR_CHILE = 12L;

    private LoadingCache<MessageTemplateId, MessageTemplateDTO> messageTemplatesCache = CacheBuilder.newBuilder()
        .maximumSize(200)
        .expireAfterWrite(30, TimeUnit.MINUTES)
        .build(
            new CacheLoader<MessageTemplateId, MessageTemplateDTO>() {
                public MessageTemplateDTO load(final MessageTemplateId messageTemplateId) {
                    return messageTemplateDAO.findMessageTemplate(messageTemplateId.getPortalId(),
                        messageTemplateId.getMessageEventId(),
                        messageTemplateId.getLocale());
                }
            });

    @PersistenceContext
    transient EntityManager entityManager;

    @Autowired
    private MessageTemplateDAO messageTemplateDAO;

    @Autowired
    private JmsTemplate sendEmailQueueJmsProducerTemplate;

    public ProfileDTO getUserProfile(Long userId, Integer portalId){
        return ensureProfile(userId, portalId);
    }

    public ProfileDTO ensureProfile(Long userId, Integer portalId){

        Query query = entityManager.createNamedQuery(Perfil.Queries.FIND_PERFIL_BY_USER_ID_AND_PORTAL);
        query.setParameter("userId", userId);
        query.setParameter("portalId", portalId);
        List<Perfil> perfils = query.getResultList();

        Perfil perfil;

        if(!perfils.isEmpty()){
            perfil  = perfils.get(0);
        }else{
            Portal portal = entityManager.find(Portal.class, portalId);
            perfil = new Perfil();
            perfil.setPortalId(portalId);
            perfil.setCreatedAt(new Date());
            perfil.setEntityId(userId);
            perfil.setLocale(portal.getPortalDefaultLocale());
            perfil.setCurrencyCode(portal.getPortalDefaultCurrency());
            perfil.setTimezoneId(portal.getTimezoneId());
            entityManager.persist(perfil);
        }

        ProfileDTO profile = new ProfileDTO();
        profile.setTimezone(perfil.getTimezoneId());
        profile.setCurrency(perfil.getCurrencyCode());
        profile.setLocale(perfil.getLocale());
        return profile;

    }

    public PreLancamento getPreEntryByOfferId(Long offerId){
        TypedQuery<PreLancamento> query = entityManager.createNamedQuery(PreLancamento.Queries.FIND_PRE_LANCAMENTO_BY_OFFER_ID, PreLancamento.class);
        query.setParameter("offerId", offerId);
        List<PreLancamento> list = query.getResultList();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("pre_entry_not_found");
        }
        return list.get(0);

    }

    private Map<TipoItemPagamentoEnum, GrupoOfertaPercentual> getGrupoOfertaPercentualPorTipoPagamento(Long groupOfferId) {

        TypedQuery<GrupoOfertaPercentual> query = entityManager.createNamedQuery(GrupoOfertaPercentual.Queries.FIND_GRUPO_OFERTA_COMISSAO, GrupoOfertaPercentual.class);
        query.setParameter("groupOfferId", groupOfferId);
        List<GrupoOfertaPercentual> listGrupoOfertaPercentual = query.getResultList();

        // Organizar items  por tipo item pagamento
        Map<TipoItemPagamentoEnum, GrupoOfertaPercentual> grupoOfertaPercentualMap = new HashMap<TipoItemPagamentoEnum, GrupoOfertaPercentual>();
        for(GrupoOfertaPercentual grupoOfertaPercentual: listGrupoOfertaPercentual){
            grupoOfertaPercentualMap.put(
                TipoItemPagamentoEnum.get(grupoOfertaPercentual.getTipoItemPagamento().getId()),
                grupoOfertaPercentual);

        }
        return grupoOfertaPercentualMap;
    }

    public Map<TipoItemPagamentoEnum, Lancamento> getLancamentoPorTipoPagamento(Long preEntryId){
        List<GrupoLancamento> saleOrders = getSaleOrdersLastestGenerationByPreEntry(preEntryId);

        // Organizar items  por tipo item pagamento
        Map<TipoItemPagamentoEnum, Lancamento> lancamentosPorTipoItemPagamento = new HashMap<TipoItemPagamentoEnum, Lancamento>();
        for(GrupoLancamento saleOrder: saleOrders){
            Set<Lancamento> saleOrderEntries = saleOrder.getLancamento();
            for(Lancamento saleOrderEntry: saleOrderEntries){
                lancamentosPorTipoItemPagamento.put(
                    TipoItemPagamentoEnum.get(saleOrderEntry.getTipoItemPagamento().getId()), saleOrderEntry);
            }
        }

        return lancamentosPorTipoItemPagamento;
    }

    public Map<TipoItemPagamentoEnum, PreLancamentoItem> getPreLancamentoItemsPorTipoPagamento(PreLancamento preEntry){

        Map<TipoItemPagamentoEnum, PreLancamentoItem> preLancamentosPorTipoItemPagamento = new HashMap<TipoItemPagamentoEnum, PreLancamentoItem>();
        for(PreLancamentoItem preLancamentoItem : preEntry.getPreLancamentoItem()){
            preLancamentosPorTipoItemPagamento.put(TipoItemPagamentoEnum.get(preLancamentoItem.getTipoItemPagamento().getId()), preLancamentoItem);
        }

        return preLancamentosPorTipoItemPagamento;
    }
    public List<GrupoLancamento> getSaleOrdersLastestGenerationByPreEntry(Long preEntryId){
        TypedQuery<GrupoLancamento> query = entityManager.createNamedQuery(GrupoLancamento.Queries.FIND_GRUPO_LANCAMENTO_ULTIMA_GERACAO, GrupoLancamento.class);
        query.setParameter("preLancamentoId", preEntryId);
        List<GrupoLancamento> list = query.getResultList();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("sale_order_not_found");
        }

        return list;

    }

    public Email getEmailMasterByUserId(Long userId){
        TypedQuery<Email> query = entityManager.createNamedQuery(Email.Queries.FIND_EMAIL_FROM_USER, Email.class);
        query.setParameter("entityId", userId);
        List<Email> list = query.getResultList();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("email_not_found");
        }
        return list.get(0);

    }

    public PortalInfosDTO getPortalInfos(Integer portalId){
        Query query = entityManager.createNamedQuery(Portal.Queries.FIND_PORTAL_INFOS);
        query.setParameter("portalId", portalId);
        PortalInfosDTO portalInfosDTO = (PortalInfosDTO)query.getSingleResult();
        return portalInfosDTO;
    }

    @Transactional
    public boolean checkAllIntegrationsCompleted(Venda venda){
        return venda.isAllIntegrationsCompleted();
    }

    @Transactional
    public void sendPendingNotifications() {

        Query query = entityManager.createNamedQuery(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS);
        List<Venda> vendasComNotificacoesPendentes = (List<Venda>) query.getResultList();

        for(Venda venda : vendasComNotificacoesPendentes){
            try {

                if(checkAllIntegrationsCompleted(venda)) {
                    sendWinnerNotification(venda.getOfertaId());
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Transactional
    public EmailMessage sendWinnerNotification(long offerId) throws Exception {
        EmailMessage emailMessage = sendWinnerNotification(offerId, null);
        return emailMessage;
    }

    @Transactional
    public EmailMessage sendWinnerNotification(long offerId, Venda venda) throws Exception {

        try {

            if(venda == null){
                Query query = entityManager.createNamedQuery(Venda.Queries.FIND_AUCTION_ACTIVE_SALE_BY_LOT);
                query.setParameter("ofertaId", offerId);
                venda = (Venda) query.getSingleResult();
            }

            // Consulta de dados para o email.
            PreLancamento preEntry = getPreEntryByOfferId(offerId);

            // Dados do lote
            Offer offer = preEntry.getOffer();
            Auction auction = offer.getAuction();
            Gestor gestor = auction.getGestor();

            // Entidades envolvidas
            UserEntity winnerEntity = entityManager.find(UserEntity.class, preEntry.getArrematanteId());
            Email winnerEmail = getEmailMasterByUserId(winnerEntity.getId());
            ProfileDTO winnerProfile = getUserProfile(winnerEntity.getId(), auction.getPortalId());
            UserEntity sellerEntity = preEntry.getComitente();

            // Entidades envolvidas
            PortalInfosDTO portalInfosDTO = getPortalInfos(auction.getPortalId());

            MessageTemplateDTO messageTemplate = findMessageTemplate(preEntry, auction.getPortalId(), winnerProfile.getLocale(), venda);

            // Consulta Items de Pagamento no Grupo Oferta
            Map<TipoItemPagamentoEnum, GrupoOfertaPercentual> grupoOfertaPercentual =
                getGrupoOfertaPercentualPorTipoPagamento(offer.getGroupOfferId());

            Map<String, String> expressions;
            if (venda.getAuction().getAuctionModalityId() == MODALIDADE_VENDA_DIRETA) {

                // Definicao de valores das chaves
                expressions =
                    createDirectSaleKeyValueExpressions(offer, auction, winnerEntity, portalInfosDTO, grupoOfertaPercentual);
            } else {
                // Consulta Items de Pagamento no Grupo Lancamento
                Map<TipoItemPagamentoEnum, Lancamento> lancamentos = getLancamentoPorTipoPagamento(preEntry.getId());

                // Definicao de valores das chaves
                expressions =
                    createAuctionKeyValueExpressions(preEntry, offer, auction, gestor, winnerEntity,
                        winnerEmail, sellerEntity, portalInfosDTO, winnerProfile,
                        lancamentos, grupoOfertaPercentual);
            }

            // Substituicao dos valores com as chaves definidas
            final EmailMessage emailMessage =
                createEmailMessage(expressions, messageTemplate, winnerEmail.getAddress(), winnerEntity.getName());

            // Envio do email para a fila
            sendEmailQueueJmsProducerTemplate.send(new MessageCreator() {
                @Override
                public javax.jms.Message createMessage(Session session) throws JMSException {
                    return session.createObjectMessage(emailMessage);
                }
            });

            venda.setEmailVendaEnviado(true);

            return emailMessage;

        }catch (Exception e){
            throw e;
        }
    }

    private MessageTemplateDTO findMessageTemplate(PreLancamento preEntry, int portalId, String locale,
                                                   Venda venda) {

        boolean conditionalBid = false;
        int messageEventId;
        if (venda.getAuction().getAuctionModalityId() == MODALIDADE_VENDA_DIRETA) {
            final long offerType = venda.getOffer().getTypeId();
            messageEventId = getMessageEventId(offerType);
        } else {
            // Define se e condicional
            conditionalBid = preEntry.getPreLancamentoStatusId() == PreLancamentoTipo.CONDITIONAL;
            // Definicao do template a ser utilizado
            messageEventId = (conditionalBid) ? TRANSACAO_LANCE_CONDICIONAL_ACEITO : TRANSACAO_LANCE_VENCEDOR;
        }

        final MessageTemplateId messageTemplateId = new MessageTemplateId(portalId, messageEventId, locale);
        return messageTemplatesCache.getUnchecked(messageTemplateId);
    }

    private int getMessageEventId(long offerType) {
        int messageEventId;
        if (offerType == OFFER_TYPE_COMPRE_JA) {
            messageEventId = TRANSACAO_COMPREJA_VENDA_GERADA;
        } else if (offerType == OFFER_TYPE_PROPOSTA) {
            messageEventId = TRANSACAO_PROPOSTA_VENDA_GERADA;
        } else if (offerType == OFFER_TYPE_HIBRIDO) {
            messageEventId = TRANSACAO_HIBRIDO_VENDA_GERADA;
        } else {
            throw new IllegalStateException("Unknown offer type for direct sale");
        }
        return messageEventId;
    }

    private EmailMessage createEmailMessage(Map<String, String> expressions, MessageTemplateDTO messageTemplate, String toAddress, String toName) {
        // 4. Processa chaves dinamicas no body da mensagem.
        String emailMessageBody;
        try {
            String body = messageTemplate.getMessageBody();
            emailMessageBody = MtpUtils.replaceExpressions(expressions, body);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("email_template_not_found");
        }

        if (log.isDebugEnabled()) {
            log.debug("\n\n==================== [template body processed]===================== \n\n");
            log.debug(emailMessageBody + "\n\n");
        }

        // 5. Processa chaves dinamicas no body da mensagem.
        String subject = messageTemplate.getMessageSubject();
        String emailMessageSubject = MtpUtils.replaceExpressions(expressions, subject);

        if (log.isDebugEnabled()) {
            log.debug("\n\n==================== [template subject processed]===================== \n\n");
            log.debug(emailMessageSubject + "\n\n");
        }

        // 6. Cria mensagem de email para o java mail e envia para o smtp via spring mesage sender.


        final EmailMessage emailMessage = new EmailMessage();
        emailMessage.setSubject(emailMessageSubject);
        emailMessage.setText(emailMessageBody);
        toAddress = checkComprova(messageTemplate,toAddress);
        emailMessage.setFromAddress(messageTemplate.getMessageFromAddress());
        emailMessage.setFromName(messageTemplate.getMessageFromName());
        emailMessage.setToAddress(toAddress);
        emailMessage.setToName(toName);

        return emailMessage;
    }

    private String checkComprova(MessageTemplateDTO messageTemplate, String toAddress) {
        if(messageTemplate.isComprovaSufixo()){
            toAddress += ".comprova.com";
        }
        return toAddress;
    }

    public TributoLancamento getTributo(Long entryGroupId, Long itemTypeId){

        TypedQuery<TributoLancamento> query = entityManager.createNamedQuery(TributoLancamento.Queries.FIND_TRIBUTOS_BY_ENTRY_GROUP_AND_TYPE, TributoLancamento.class);
        query.setParameter("entryGroupId", entryGroupId);
        query.setParameter("itemTypeId", itemTypeId);
        List<TributoLancamento> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }else {
            return list.get(0);
        }

    }

    private BigDecimal getValorTotalItem(Map<TipoItemPagamentoEnum, Lancamento> lancamentosPorTipoItemPagamento, TipoItemPagamentoEnum itemTipo, Long gestorId){
        Lancamento item = lancamentosPorTipoItemPagamento.get(itemTipo);

        if(item != null){
            if(!gestorId.equals(GESTOR_CHILE)){
                return item.getValorItem().add(item.getValorImposto());
            }else{

                //TODO workaround para o chile , tratar quando for para o brazil de uma forma generica.
                TributoLancamento tributo = getTributo(item.getGrupoLancamento().getId(), item.getTipoItemPagamentoId());
                if(tributo != null){
                    return item.getValorItem().add(tributo.getValor());
                }else{
                    return item.getValorItem();
                }

            }
        } else{
            return new BigDecimal(0);
        }
    }

    private Double getValorTotal(Map<TipoItemPagamentoEnum, Lancamento> lancamentosPorTipoItemPagamento, Long gestorId){

        BigDecimal valorTotal = new BigDecimal(0.0);
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_LOTE,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_COMISSAO_LEILOEIRO,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_TAXA_ADMINISTRATIVA,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_COMISSAO_CESSIONARIA,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_FIXO_1,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.VALOR_FIXO_2,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.PORCENTAGEM_1,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.PORCENTAGEM_2,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.FAIXA_VALOR_1,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.FAIXA_VALOR_2,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.SERVICO_TRANSFERENCIA,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.SOLICITACAO_DE_TRANSFERENCIA,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.IMPOSTO_TESORERIA,gestorId));
        valorTotal = valorTotal.add(getValorTotalItem(lancamentosPorTipoItemPagamento,TipoItemPagamentoEnum.CONDICIONADOS,gestorId));

        return valorTotal.doubleValue();
    }

    private Map<String, String> createAuctionKeyValueExpressions(PreLancamento preEntry, Offer offer, Auction auction,
                                                                 Gestor gestor, UserEntity winnerEntity, Email winnerEmail,
                                                                 UserEntity sellerEntity, PortalInfosDTO portalInfosDTO, ProfileDTO profile,
                                                                 Map<TipoItemPagamentoEnum, Lancamento> lancamentosPorTipoItemPagamento,
                                                                 Map<TipoItemPagamentoEnum, GrupoOfertaPercentual> grupoOfertaPercentual) {

        Map<String, String> expressions = new HashMap<String, String>();

        Locale auctionLocale = I18nHelper.parseLocale(auction.getLocaleId());
        DateFormat dateFormatBR = DateFormat.getDateInstance(DateFormat.FULL, auctionLocale);

        // Infos do Lote, Comprador e Vendedor
        expressions.put("arrematante.nome",winnerEntity.getName());
        expressions.put("gestor.nome",gestor.getGestorTitle());
        expressions.put("leilao.numero", String.valueOf(auction.getId()));
        expressions.put("leilao.nome",auction.getAuctionDesc());
        expressions.put("leilao.data", dateFormatBR.format(auction.getAuctionEndDate()));
        expressions.put("lote.numero",offer.getLotNumberDesc());
        expressions.put("lote.comitenteNome",sellerEntity.getName());
        expressions.put("lote.descricaoCurta",offer.getProduct().getProductShortDesc());

        // Infos Financeiras
        expressions.put("lance.valor", I18nHelper.formatCurrencyToLocale(preEntry.getValorLance().doubleValue(), auction.getLocaleId()));
        expressions.put("venda.numeroTransacao", String.valueOf(preEntry.getId()));
        expressions.put("venda.quantidade", String.valueOf(preEntry.getQuantidadeArrematada()));

        Long gestorId = Long.valueOf(auction.getGestor().getId());

        populateItemPagamentoExpression("venda.valorComissaoLeiloeiro", TipoItemPagamentoEnum.VALOR_COMISSAO_LEILOEIRO,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorTaxaAdm", TipoItemPagamentoEnum.VALOR_TAXA_ADMINISTRATIVA,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.comissaoCessionaria", TipoItemPagamentoEnum.VALOR_COMISSAO_CESSIONARIA,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorFixo1", TipoItemPagamentoEnum.VALOR_FIXO_1,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorFixo2", TipoItemPagamentoEnum.VALOR_FIXO_2,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorPorcentagem1", TipoItemPagamentoEnum.PORCENTAGEM_1,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorPorcentagem2", TipoItemPagamentoEnum.PORCENTAGEM_2,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorFaixa1", TipoItemPagamentoEnum.FAIXA_VALOR_1,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorFaixa2", TipoItemPagamentoEnum.FAIXA_VALOR_2,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.valorLote", TipoItemPagamentoEnum.VALOR_LOTE,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.servicoTransferencia", TipoItemPagamentoEnum.SERVICO_TRANSFERENCIA,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.solicitacaoTransferencia", TipoItemPagamentoEnum.SOLICITACAO_DE_TRANSFERENCIA,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.impostoTesoreria", TipoItemPagamentoEnum.IMPOSTO_TESORERIA,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);

        populateItemPagamentoExpression("venda.condicionados", TipoItemPagamentoEnum.CONDICIONADOS,
            expressions, lancamentosPorTipoItemPagamento, auctionLocale, gestorId);


        // IMPORTANTE : A multa se refere aos items persistidos na tabela de GRUPO_OFERTA TAXA
        // antes mesmo da existencia dos dados de PreLancamento ou GrupoLancamento.
        populateGrupoOfertaPercentualExpression("venda.multaDespesasAdm", TipoItemPagamentoEnum.MULTA,
            expressions, grupoOfertaPercentual, auctionLocale);

        // IMPORTANTE : A multa se refere aos items persistidos na tabela de GRUPO_OFERTA COMISSAO
        // antes mesmo da existencia dos dados de PreLancamento ou GrupoLancamento.
        populateGrupoOfertaPercentualExpression("venda.multaLeiloeiro", TipoItemPagamentoEnum.VALOR_COMISSAO_LEILOEIRO,
            expressions, grupoOfertaPercentual, auctionLocale);



        expressions.put("venda.valorTotal", I18nHelper.formatCurrencyToLocale(getValorTotal(lancamentosPorTipoItemPagamento, gestorId), auction.getLocaleId()));

        // LINKs
        expressions.put("leilao.linkCondicaoVenda", "http://"+ portalInfosDTO.getPortalOfficialURL()+"/leilao/condicoesvenda.htm?auction_id="+auction.getId());
        expressions.put("venda.linkBoleto","http://"+ portalInfosDTO.getPortalOfficialURL());
        expressions.put("portal.link","http://"+ portalInfosDTO.getPortalOfficialURL());

        expressions.put("cobranca.email", portalInfosDTO.getCacEmail());

        // Infos CAC
        expressions.put("cac.foneDDI", portalInfosDTO.getPhoneFixo().getPhoneDDI());
        expressions.put("cac.foneDDD", portalInfosDTO.getPhoneFixo().getPhoneDDD());
        expressions.put("cac.foneNumero", portalInfosDTO.getPhoneFixo().getPhoneNumber());
        expressions.put("cac.faxDDI", portalInfosDTO.getPhoneFax().getPhoneDDI());
        expressions.put("cac.faxDDD", portalInfosDTO.getPhoneFax().getPhoneDDD());
        expressions.put("cac.faxNumero", portalInfosDTO.getPhoneFax().getPhoneNumber());
        expressions.put("cac.email", portalInfosDTO.getCacEmail());
        expressions.put("portal.name", portalInfosDTO.getPortalName());
        expressions.put("portal.descricao", portalInfosDTO.getPortalDescription());

        return expressions;

    }

    private Map<String,String> createDirectSaleKeyValueExpressions(Offer offer, Auction auction, UserEntity winnerEntity, PortalInfosDTO portalInfosDTO,
                                                                   Map<TipoItemPagamentoEnum,GrupoOfertaPercentual> grupoOfertaPercentual) {

        Map<String, String> expressions = new HashMap<String, String>();

        Locale auctionLocale = I18nHelper.parseLocale(auction.getLocaleId());

        // Infos do Lote, Comprador e Vendedor
        expressions.put("arrematante.nome", winnerEntity.getName());
        expressions.put("lote.descricaoCurta", offer.getProduct().getProductShortDesc());

        // IMPORTANTE : A multa se refere aos items persistidos na tabela de GRUPO_OFERTA TAXA
        // antes mesmo da existencia dos dados de PreLancamento ou GrupoLancamento.
        populateGrupoOfertaPercentualExpression("venda.multaDespesasAdm", TipoItemPagamentoEnum.MULTA,
            expressions, grupoOfertaPercentual, auctionLocale);

        // IMPORTANTE : A multa se refere aos items persistidos na tabela de GRUPO_OFERTA COMISSAO
        // antes mesmo da existencia dos dados de PreLancamento ou GrupoLancamento.
        populateGrupoOfertaPercentualExpression("venda.multaLeiloeiro", TipoItemPagamentoEnum.VALOR_COMISSAO_LEILOEIRO,
            expressions, grupoOfertaPercentual, auctionLocale);

        // Infos CAC
        expressions.put("cac.email", portalInfosDTO.getCacEmail());
        expressions.put("cac.foneDDI", portalInfosDTO.getPhoneFixo().getPhoneDDI());
        expressions.put("cac.foneDDD", portalInfosDTO.getPhoneFixo().getPhoneDDD());
        expressions.put("cac.foneNumero", portalInfosDTO.getPhoneFixo().getPhoneNumber());
        expressions.put("cac.faxDDI", portalInfosDTO.getPhoneFax().getPhoneDDI());
        expressions.put("cac.faxDDD", portalInfosDTO.getPhoneFax().getPhoneDDD());
        expressions.put("cac.faxNumero", portalInfosDTO.getPhoneFax().getPhoneNumber());

        return expressions;
    }

    private void populateGrupoOfertaPercentualExpression(String key, TipoItemPagamentoEnum tipoItemPagamento,
                                                         Map<String, String> expressions,
                                                         Map<TipoItemPagamentoEnum, GrupoOfertaPercentual> grupoOfertaPercentual,
                                                         Locale locale){

        GrupoOfertaPercentual percentual = grupoOfertaPercentual.get(tipoItemPagamento);
        if(percentual != null) {
            expressions.put(key, String.valueOf(percentual.getComissao()) + "%");
        } else {
            expressions.put(key, "-");
            if(log.isDebugEnabled()) {
                log.warn("A chave " + key + ", foi ignorada, o tipo item pagamento "
                    + tipoItemPagamento.getId() + " - " + tipoItemPagamento.getDescricao()
                    + " é inexistente para o lote.");
            }
        }

    }

    private void populateItemPagamentoExpression(String key, TipoItemPagamentoEnum tipoItemPagamento,
                                                 Map<String, String> expressions,
                                                 Map<TipoItemPagamentoEnum, Lancamento> lancamentosPorTipoItemPagamento,
                                                 Locale locale, Long gestorId){

        Lancamento lancamento = lancamentosPorTipoItemPagamento.get(tipoItemPagamento);

        BigDecimal valorTotal = getValorTotalItem(lancamentosPorTipoItemPagamento,tipoItemPagamento, gestorId);

        if(lancamento != null) {
            expressions.put(key, I18nHelper.parseMoeda(valorTotal.doubleValue(), locale));
        } else {
            expressions.put(key, I18nHelper.parseMoeda(0.0, locale));
            if(log.isDebugEnabled()) {
                log.warn("A chave " + key + ", foi ignorada, o tipo item pagamento "
                    + tipoItemPagamento.getId() + " - " + tipoItemPagamento.getDescricao()
                    + " é inexistente para o lote.");
            }
        }

    }

}

@Data
@AllArgsConstructor
class MessageTemplateId {
    private int portalId;
    private int messageEventId;
    private String locale;
}