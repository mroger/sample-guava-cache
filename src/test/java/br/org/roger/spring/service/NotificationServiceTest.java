package br.org.roger.spring.service;

import br.org.roger.spring.dao.MessageTemplateDAO;
import br.org.roger.spring.domain.*;
import br.org.roger.spring.dto.MessageTemplateDTO;
import br.org.roger.spring.dto.PortalInfosDTO;
import br.org.roger.spring.dto.ProfileDTO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {
    private static String conditionalBidMessageBody;
    private static String winnerBidMessageBody;
    private static String compreJaMessageBody;
    private static String propostaMessageBody;
    private static String hibridoMessageBody;

    private static String expectedConditionalMessageSubject;
    private static String expectedConditionalBidMessageBody;
    private static String expectedWinnerBidMessageSubject;
    private static String expectedWinnerBidMessageBody;
    private static String expectedCompreJaMessageSubject;
    private static String expectedCompreJaMessageBody;
    private static String expectedPropostaMessageSubject;
    private static String expectedPropostaMessageBody;
    private static String expectedHibridoMessageSubject;
    private static String expectedHibridoMessageBody;

    @Mock
    EntityManager entityManager;

    @Mock
    private MessageTemplateDAO messageTemplateDAO;

    @Mock
    private JmsTemplate sendEmailQueueJmsProducerTemplate;

    @Spy
    @InjectMocks
    private NotificationService notificationService;

    @BeforeClass
    public static void setupClass() throws IOException {
        conditionalBidMessageBody = loadTemplateMessage("conditionalBidMessageBody.tpl");
        winnerBidMessageBody = loadTemplateMessage("winnerBidMessageBody.tpl");
        compreJaMessageBody = loadTemplateMessage("compreJaMessageBody.tpl");
        propostaMessageBody = loadTemplateMessage("propostaMessageBody.tpl");
        hibridoMessageBody = loadTemplateMessage("hibridoMessageBody.tpl");

        expectedConditionalMessageSubject = loadExpectedMessage("expectedConditionalMessageSubject.txt");
        expectedConditionalBidMessageBody = loadExpectedMessage("expectedConditionalBidMessageBody.txt");
        expectedWinnerBidMessageSubject = loadExpectedMessage("expectedWinnerBidMessageSubject.txt");
        expectedWinnerBidMessageBody = loadExpectedMessage("expectedWinnerBidMessageBody.txt");
        expectedCompreJaMessageSubject = loadExpectedMessage("expectedCompreJaMessageSubject.txt");
        expectedCompreJaMessageBody = loadExpectedMessage("expectedCompreJaMessageBody.txt");
        expectedPropostaMessageSubject = loadExpectedMessage("expectedPropostaMessageSubject.txt");
        expectedPropostaMessageBody = loadExpectedMessage("expectedPropostaMessageBody.txt");
        expectedHibridoMessageSubject = loadExpectedMessage("expectedHibridoMessageSubject.txt");
        expectedHibridoMessageBody = loadExpectedMessage("expectedHibridoMessageBody.txt");
    }

    private static String loadTemplateMessage(String templateFile) throws IOException {
        return loadMessage("messageTemplates/" + templateFile);
    }

    private static String loadExpectedMessage(String expectedFile) throws IOException {
        return loadMessage("messageResults/" + expectedFile);
    }

    private static String loadMessage(String expectedFile) throws IOException {
        ClassLoader classLoader = NotificationServiceTest.class.getClassLoader();
        File file = new File(classLoader.getResource(expectedFile).getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotSendPendingNotifications_whenNoSaleIsFound() throws Exception {

        createEmptyListOfVendas();

        notificationService.sendPendingNotifications();

        verify(notificationService, never()).sendWinnerNotification(anyLong());
        verify(notificationService, never()).sendWinnerNotification(anyLong(), any(Venda.class));
    }

    @Test
    public void shouldSendPendingNotifications_whenSalesHaveNoGrupoLancamento() throws Exception {

        createListOfVendasWithNoGrupoLancamento();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenSalesHaveGrupoLancamentosWithNoGrupoLancamentoIntegracao() throws Exception {

        createListOfVendasWithGrupoLancamentoAndNoGrupoLancamentoIntegracao();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenIntegracaoIsNotImpostoNorLancamentoNorPagamento() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsNotImpostoNorLancamentoNorPagamento();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenIntegracaoIsImpostoButIsNotPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsImpostoButNotPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenIntegracaoIsLancamentoButIsNotPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsLancamentoButNotPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenIntegracaoIsPagamentoButIsNotPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsPagamentoButNotPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldSendPendingNotifications_whenHasAllKindsOfIntegracaoButIsNotPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsOfAllKindsButNotPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyOnceSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyOnceSendWinnerNotification(3L);
    }

    @Test
    public void shouldNotSendPendingNotifications_whenIntegracaoIsImpostoAndIsPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsImpostoAndIsPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyNeverSendWinnerNotification(1L);
        verifyNeverSendWinnerNotification(2L);
        verifyNeverSendWinnerNotification(3L);
    }

    @Test
    public void shouldNotSendPendingNotifications_whenIntegracaoIsLancamentoAndIsPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsLancamentoAndIsPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyNeverSendWinnerNotification(1L);
        verifyNeverSendWinnerNotification(2L);
        verifyNeverSendWinnerNotification(3L);
    }

    @Test
    public void shouldNotSendPendingNotifications_whenIntegracaoIsPagamentoAndIsPending() throws Exception {

        createListOfVendasWithGrupoLancamentoAndIntegracaoIsLancamentoAndIsPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyNeverSendWinnerNotification(1L);
        verifyNeverSendWinnerNotification(2L);
        verifyNeverSendWinnerNotification(3L);
    }

    @Test
    public void shouldNotSendSomePendingNotifications_whenSomeVendaHasIntegracaoThatIsPagamentoAndIsPending()
        throws Exception {

        createListOfVendasWithGrupoLancamentoAndSomeHasIntegracaoThatIsPagamentoAndIsPending();
        doReturn(null).when(notificationService).sendWinnerNotification(anyLong());

        notificationService.sendPendingNotifications();

        verifyNeverSendWinnerNotification(1L);
        verifyOnceSendWinnerNotification(2L);
        verifyNeverSendWinnerNotification(3L);
    }

    @Test
    public void sendPendingNotificationsForConditionalBidSaleForWhichModalityIsNotDirectSale() throws ParseException {

        Venda venda = createResultsetForConditionalBidSaleWhichIsNotDirectSale();

        notificationService.sendPendingNotifications();

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
    }

    @Test
    public void sendWinnerNotificationForConditionalBidSale() throws Exception {

        Venda venda = createResultsetForConditionalBidSaleWhichIsNotDirectSale();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
        assertEquals(expectedConditionalMessageSubject, emailMessage.getSubject());
        assertEquals(expectedConditionalBidMessageBody, emailMessage.getText());
    }

    @Test
    public void sendPendingNotificationsForWinnerBidSaleForWhichModalityIsNotDirectSale() throws ParseException {

        Venda venda = createResultsetForWinnerBidSaleWhichIsNotDirectSale();

        notificationService.sendPendingNotifications();

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
    }

    @Test
    public void sendWinnerNotificationForWinnerBidSale() throws Exception {

        Venda venda = createResultsetForWinnerBidSaleWhichIsNotDirectSale();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
        assertEquals(expectedWinnerBidMessageSubject, emailMessage.getSubject());
        assertEquals(expectedWinnerBidMessageBody, emailMessage.getText());
    }

    @Test
    public void sendPendingNotificationsForSaleForWhichModalityIsDirectSaleOfferTypeCompreJa() throws Exception {

        Venda venda = createResultsetForBidSaleWhichIsDirectSaleOfferTypeCompreJa();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
        assertEquals(expectedCompreJaMessageSubject, emailMessage.getSubject());
        assertEquals(expectedCompreJaMessageBody, emailMessage.getText());
    }

    @Test
    public void sendPendingNotificationsForSaleForWhichModalityIsDirectSaleOfferTypeProposta() throws Exception {

        Venda venda = createResultsetForBidSaleWhichIsDirectSaleOfferTypeProposta();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
        assertEquals(expectedPropostaMessageSubject, emailMessage.getSubject());
        assertEquals(expectedPropostaMessageBody, emailMessage.getText());
    }

    @Test
    public void sendPendingNotificationsForSaleForWhichModalityIsDirectSaleOfferTypeHibrido() throws Exception {

        Venda venda = createResultsetForBidSaleWhichIsDirectSaleOfferTypeHibrido();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(1)).send(any(MessageCreator.class));
        assertTrue(venda.getEmailVendaEnviado());
        assertEquals(expectedHibridoMessageSubject, emailMessage.getSubject());
        assertEquals(expectedHibridoMessageBody, emailMessage.getText());
    }

    @Test
    public void shouldUseCacheToStoreMessageTemplates() throws Exception {
        Venda venda = createResultsetForBidSaleWhichIsDirectSaleOfferTypeHibrido();

        EmailMessage emailMessage = notificationService.sendWinnerNotification(venda.getOfertaId(), null);
        notificationService.sendWinnerNotification(venda.getOfertaId(), null);
        notificationService.sendWinnerNotification(venda.getOfertaId(), null);
        notificationService.sendWinnerNotification(venda.getOfertaId(), null);

        verify(sendEmailQueueJmsProducerTemplate, times(4)).send(any(MessageCreator.class));
        verify(messageTemplateDAO).findMessageTemplate(2, 110, "pt_BR");
        assertTrue(venda.getEmailVendaEnviado());
    }

    private Venda createResultsetForBidSaleWhichIsDirectSaleOfferTypeCompreJa() throws ParseException {
        return createResultsetForBidSale(PreLancamentoTipo.CONDITIONAL, NotificationService.MODALIDADE_VENDA_DIRETA,
            NotificationService.OFFER_TYPE_COMPRE_JA);
    }

    private Venda createResultsetForBidSaleWhichIsDirectSaleOfferTypeProposta() throws ParseException {
        return createResultsetForBidSale(PreLancamentoTipo.CONDITIONAL, NotificationService.MODALIDADE_VENDA_DIRETA,
            NotificationService.OFFER_TYPE_PROPOSTA);
    }

    private Venda createResultsetForBidSaleWhichIsDirectSaleOfferTypeHibrido() throws ParseException {
        return createResultsetForBidSale(PreLancamentoTipo.CONDITIONAL, NotificationService.MODALIDADE_VENDA_DIRETA,
            NotificationService.OFFER_TYPE_HIBRIDO);
    }

    private Venda createResultsetForConditionalBidSaleWhichIsNotDirectSale() throws ParseException {
        return createResultsetForBidSale(PreLancamentoTipo.CONDITIONAL, NotificationService.MODALIDADE_LEILAO,
            NotificationService.OFFER_TYPE_LEILAO_CONVENCIONAL);
    }

    private Venda createResultsetForWinnerBidSaleWhichIsNotDirectSale() throws ParseException {
        return createResultsetForBidSale(PreLancamentoTipo.VENDA, NotificationService.MODALIDADE_LEILAO,
            NotificationService.OFFER_TYPE_LEILAO_CONVENCIONAL);
    }

    private Venda createResultsetForBidSale(final int preLancamentoTipo, final int auctionModalityId, final long offerTypeId) throws ParseException {

        Venda venda = createResultsetForSaleNotDirectSale(auctionModalityId, offerTypeId);
        createResultsetForActiveSale(venda);

        UserEntity comitente = new UserEntity();
        comitente.setName("Comitente Name 1");
        PreLancamento preLancamento = new PreLancamento();
        preLancamento.setId(25L);
        preLancamento.setPreLancamentoStatusId(preLancamentoTipo);
        preLancamento.setOffer(venda.getOffer());
        preLancamento.setArrematanteId(5L);
        preLancamento.setComitente(comitente);
        preLancamento.setValorLance(new BigDecimal("100.0"));

        createPreEntryByOfferId(preLancamento);

        UserEntity winnerEntity = new UserEntity();
        winnerEntity.setId(10L);
        winnerEntity.setName("Winner 1");
        when(entityManager.find(UserEntity.class, 5L)).thenReturn(winnerEntity);

        Email winnerEmail = new Email();
        winnerEmail.setAddress("to@address.com");

        createEmailMasterByUserId(winnerEmail);

        ProfileDTO winnerProfile = new ProfileDTO();
        winnerProfile.setLocale("pt_BR");

        createWinnerUserProfile(winnerProfile);

        Phone foneFixo = new Phone();
        foneFixo.setPhoneDDI("+55");
        foneFixo.setPhoneDDD("11");
        foneFixo.setPhoneNumber("966667777");
        Phone foneFax = new Phone();
        foneFax.setPhoneDDI("+55");
        foneFax.setPhoneDDD("21");
        foneFax.setPhoneNumber("966668888");
        PortalInfosDTO portalInfosDTO = new PortalInfosDTO(15, "Portal 1","portalOfficialURL", "portalAppContext",
            "portalDescription", "cacEmail", foneFixo, foneFax);

        createPortalInfos(portalInfosDTO);

        if (auctionModalityId == NotificationService.MODALIDADE_LEILAO) {

            if (preLancamentoTipo == PreLancamentoTipo.CONDITIONAL) {
                MessageTemplateDTO messageTemplate = createConditionalBidMessageTemplate();
                when(messageTemplateDAO
                    .findMessageTemplate(2, NotificationService.TRANSACAO_LANCE_CONDICIONAL_ACEITO, "pt_BR"))
                    .thenReturn(messageTemplate);
            } else {
                MessageTemplateDTO messageTemplate = createWinnerBidMessageTemplate();
                when(messageTemplateDAO
                    .findMessageTemplate(2, NotificationService.TRANSACAO_LANCE_VENCEDOR, "pt_BR"))
                    .thenReturn(messageTemplate);
            }
        } else if (auctionModalityId == NotificationService.MODALIDADE_VENDA_DIRETA) {
            if (offerTypeId == NotificationService.OFFER_TYPE_COMPRE_JA) {
                MessageTemplateDTO messageTemplate = createCompreJaMessageTemplate();
                when(messageTemplateDAO
                    .findMessageTemplate(2, NotificationService.TRANSACAO_COMPREJA_VENDA_GERADA, "pt_BR"))
                    .thenReturn(messageTemplate);
            } else if (offerTypeId == NotificationService.OFFER_TYPE_PROPOSTA) {
                MessageTemplateDTO messageTemplate = createPropostaMessageTemplate();
                when(messageTemplateDAO
                    .findMessageTemplate(2, NotificationService.TRANSACAO_PROPOSTA_VENDA_GERADA, "pt_BR"))
                    .thenReturn(messageTemplate);
            } else if (offerTypeId == NotificationService.OFFER_TYPE_HIBRIDO) {
                MessageTemplateDTO messageTemplate = createHibridoMessageTemplate();
                when(messageTemplateDAO
                    .findMessageTemplate(2, NotificationService.TRANSACAO_HIBRIDO_VENDA_GERADA, "pt_BR"))
                    .thenReturn(messageTemplate);
            }
        }

        createGrupoOfertaPercentualPorTipoPagamento();

        createLancamentoPorTipoPagamento();

        return venda;
    }

    private void createPortalInfos(PortalInfosDTO portalInfosDTO) {
        Query query = mock(Query.class);
        when(query.getSingleResult()).thenReturn(portalInfosDTO);
        when(entityManager.createNamedQuery(Portal.Queries.FIND_PORTAL_INFOS)).thenReturn(query);
    }

    private void createWinnerUserProfile(ProfileDTO winnerProfile) {
        Perfil perfil = new Perfil();
        perfil.setLocale(winnerProfile.getLocale());

        Query query = mock(Query.class);
        when(query.getResultList()).thenReturn(Arrays.asList(new Perfil[] { perfil }));
        when(entityManager.createNamedQuery(Perfil.Queries.FIND_PERFIL_BY_USER_ID_AND_PORTAL)).thenReturn(query);
    }

    private void createEmailMasterByUserId(Email winnerEmail) {
        TypedQuery<Email> typedQuery = mock(TypedQuery.class);
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(new Email[] { winnerEmail }));
        when(entityManager.createNamedQuery(Email.Queries.FIND_EMAIL_FROM_USER, Email.class)).thenReturn(typedQuery);
    }

    private void createPreEntryByOfferId(PreLancamento preLancamento) {
        TypedQuery<PreLancamento> typedQuery = mock(TypedQuery.class);
        when(typedQuery.getResultList()).thenReturn(Arrays.asList(new PreLancamento[] { preLancamento }));
        when(entityManager.createNamedQuery(PreLancamento.Queries.FIND_PRE_LANCAMENTO_BY_OFFER_ID, PreLancamento.class)).thenReturn(typedQuery);
    }

    private void createGrupoOfertaPercentualPorTipoPagamento() {
        List<GrupoOfertaPercentual> listGrupoOfertaPercentual = new ArrayList<>();
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(1L, TipoItemPagamento.PAGAMENTO_LOTE, "1.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(2L, TipoItemPagamento.COMISSAO_LEILOEIRO, "2.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(3L, TipoItemPagamento.BUYERS_PREMIUM, "3.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(4L, TipoItemPagamento.COMISSAO_COMITENTE, "4.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(5L, TipoItemPagamento.TAXA_ADMINISTRATIVA, "5.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(6L, TipoItemPagamento.MULTA_COMPRADOR, "6.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(7L, TipoItemPagamento.EDITAL_COMITENTE, "7.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(8L, TipoItemPagamento.ESTADIA, "8.0"));
        listGrupoOfertaPercentual.add(createGrupoOfertaPercentual(9L, TipoItemPagamento.REMOCAO, "9.0"));

        TypedQuery<GrupoOfertaPercentual> typedQuery = mock(TypedQuery.class);
        when(typedQuery.getResultList()).thenReturn(listGrupoOfertaPercentual);
        when(entityManager.createNamedQuery(GrupoOfertaPercentual.Queries.FIND_GRUPO_OFERTA_COMISSAO, GrupoOfertaPercentual.class)).thenReturn(typedQuery);
    }

    private void createLancamentoPorTipoPagamento() {
        List<GrupoLancamento> saleOrders = new ArrayList<>();
        saleOrders.add(createGrupoLancamento());

        TypedQuery<GrupoLancamento> typedQuery = mock(TypedQuery.class);
        when(typedQuery.getResultList()).thenReturn(saleOrders);
        when(entityManager.createNamedQuery(GrupoLancamento.Queries.FIND_GRUPO_LANCAMENTO_ULTIMA_GERACAO, GrupoLancamento.class)).thenReturn(typedQuery);
    }

    private GrupoOfertaPercentual createGrupoOfertaPercentual(long id, long tipoItemPagamentoId, String value) {
        GrupoOfertaItemPagamentoId grupoOfertaItemPagamentoId = new GrupoOfertaItemPagamentoId();
        grupoOfertaItemPagamentoId.setCodTipoItemPagamento(id);
        GrupoOfertaPercentual grupoOfertaPercentual = new GrupoOfertaPercentual();
        grupoOfertaPercentual.setId(grupoOfertaItemPagamentoId);
        grupoOfertaPercentual.setComissao(new BigDecimal(value));
        grupoOfertaPercentual.setTipoItemPagamento(createTipoItemPagamento(tipoItemPagamentoId));
        return grupoOfertaPercentual;
    }

    private GrupoLancamento createGrupoLancamento() {
        Set<Lancamento> lancamentos = new HashSet<>();
        lancamentos.add(createLancamento(1, TipoItemPagamento.PAGAMENTO_LOTE, "1.0", "1.0", "1.0"));
        lancamentos.add(createLancamento(2, TipoItemPagamento.COMISSAO_LEILOEIRO, "2.0", "2.0", "2.0"));
        lancamentos.add(createLancamento(3, TipoItemPagamento.BUYERS_PREMIUM, "3.0", "3.0", "3.0"));
        lancamentos.add(createLancamento(4, TipoItemPagamento.COMISSAO_COMITENTE, "4.0", "4.0", "4.0"));
        lancamentos.add(createLancamento(5, TipoItemPagamento.TAXA_ADMINISTRATIVA, "5.0", "5.0", "5.0"));
        lancamentos.add(createLancamento(6, TipoItemPagamento.MULTA_COMPRADOR, "6.0", "6.0", "6.0"));
        lancamentos.add(createLancamento(7, TipoItemPagamento.EDITAL_COMITENTE, "7.0", "7.0", "7.0"));
        lancamentos.add(createLancamento(8, TipoItemPagamento.ESTADIA, "8.0", "8.0", "8.0"));
        lancamentos.add(createLancamento(9, TipoItemPagamento.REMOCAO, "9.0", "9.0", "9.0"));

        GrupoLancamento grupoLancamento = new GrupoLancamento();
        grupoLancamento.setLancamento(lancamentos);
        return grupoLancamento;
    }

    private Lancamento createLancamento(int id, long tipoItemPagamentoId, String valorImposto, String valorItem, String valorItemTotal) {
        TipoItemPagamento tipoItemPagamento = new TipoItemPagamento();
        tipoItemPagamento.setId(tipoItemPagamentoId);
        LancamentoId lancamentoId = new LancamentoId();
        lancamentoId.setTipoItemPagamentoId(id);
        lancamentoId.setGrupoLancamentoId((long) id);
        Lancamento lancamento = new Lancamento();
        lancamento.setId(lancamentoId);
        lancamento.setValorImposto(new BigDecimal(valorImposto));
        lancamento.setValorItem(new BigDecimal(valorItem));
        lancamento.setValorItemTotal(new BigDecimal(valorItemTotal));
        lancamento.setTipoItemPagamento(tipoItemPagamento);
        lancamento.setTipoItemPagamentoId(tipoItemPagamentoId);

        return lancamento;
    }

    private TipoItemPagamento createTipoItemPagamento(long tipoItemPagamentoId) {
        TipoItemPagamento tipoItemPagamento = new TipoItemPagamento();
        tipoItemPagamento.setId(tipoItemPagamentoId);
        tipoItemPagamento.setDesc("TipoItemPagamento " + tipoItemPagamentoId);
        return tipoItemPagamento;
    }

    private Venda createResultsetForSaleNotDirectSale(final Integer auctionModalityId, final Long offerTypeId) throws ParseException {
        final List<Venda> vendas = createSaleWithIntegrationCompleted(auctionModalityId, offerTypeId);

        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS, vendas);

        return vendas.get(0);
    }

    private void createResultsetForActiveSale(final Venda venda) throws ParseException {
        Query query = mock(Query.class);
        when(query.getSingleResult()).thenReturn(venda);
        when(entityManager.createNamedQuery(Venda.Queries.FIND_AUCTION_ACTIVE_SALE_BY_LOT)).thenReturn(query);
    }

    private List<Venda> createSaleWithIntegrationCompleted(final Integer auctionModalityId, final Long offerTypeId) throws ParseException {
        Gestor gestor = new Gestor();
        gestor.setId(50L);
        gestor.setGestorTitle("Gestor Title 1");
        Auction auction = new Auction();
        auction.setId(6L);
        auction.setAuctionDesc("Auction Desc 1");
        auction.setAuctionEndDate(new SimpleDateFormat("yyyy/MM/dd").parse("2018/07/01"));
        auction.setGestor(gestor);
        auction.setPortalId(2);
        auction.setLocaleId("pt_BR");
        auction.setAuctionModalityId(auctionModalityId);
        Product product = new Product();
        product.setProductShortDesc("Product Short Desc 1");
        Offer offer = new Offer();
        offer.setAuction(auction);
        offer.setGroupOfferId(20L);
        offer.setLotNumberDesc("Number desc 1");
        offer.setProduct(product);
        offer.setTypeId(offerTypeId);

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.SEM_INTEGRACAO));
        venda.setAuction(auction);
        venda.setOffer(offer);
        vendas.add(venda);

        return vendas;
    }

    private MessageTemplateDTO createConditionalBidMessageTemplate() {
        MessageTemplateDTO dto = new MessageTemplateDTO();
        dto.setMessageBody(conditionalBidMessageBody);
        dto.setMessageSubject("Dados para pagamento do lote ${lote.numero} do Leilao ${leilao.numero} - ${leilao.nome}");
        return dto;
    }

    private MessageTemplateDTO createWinnerBidMessageTemplate() {
        MessageTemplateDTO dto = new MessageTemplateDTO();
        dto.setMessageBody(winnerBidMessageBody);
        dto.setMessageSubject("Dados para pagamento do lote ${lote.numero} do Leilao ${leilao.numero} - ${leilao.nome}");
        return dto;
    }

    private MessageTemplateDTO createCompreJaMessageTemplate() {
        MessageTemplateDTO dto = new MessageTemplateDTO();
        dto.setMessageBody(compreJaMessageBody);
        dto.setMessageSubject("Pagamento autorizado");
        return dto;
    }

    private MessageTemplateDTO createPropostaMessageTemplate() {
        MessageTemplateDTO dto = new MessageTemplateDTO();
        dto.setMessageBody(propostaMessageBody);
        dto.setMessageSubject("Pagamento autorizado");
        return dto;
    }

    private MessageTemplateDTO createHibridoMessageTemplate() {
        MessageTemplateDTO dto = new MessageTemplateDTO();
        dto.setMessageBody(hibridoMessageBody);
        dto.setMessageSubject("Pagamento autorizado");
        return dto;
    }

     private void createListOfVendasWithGrupoLancamentoAndSomeHasIntegracaoThatIsPagamentoAndIsPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndAndSomeHasIntegracaoThatIsPagamentoAndIsPending());
    }

    private List<Venda> createVendasWithGrupoLancamentoAndAndSomeHasIntegracaoThatIsPagamentoAndIsPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        venda.setAuction(new Auction());
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(2L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.SEM_INTEGRACAO));
        venda.setAuction(new Auction());
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(3L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        venda.setAuction(new Auction());
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsLancamentoAndIsPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsLancamentoAndIsPending());
    }

    private List createVendasWithGrupoLancamentoAndIntegracaoIsLancamentoAndIsPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.AGUARDANDO_BOLETO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsImpostoAndIsPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsImpostoAndIsPending());
    }

    private List<Venda> createVendasWithGrupoLancamentoAndIntegracaoIsImpostoAndIsPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.AGUARDANDO_BOLETO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsPagamentoButNotPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsPagamentoButNotPending());
    }

    private List createVendasWithGrupoLancamentoAndIntegracaoIsPagamentoButNotPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.INTEGRADO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsLancamentoButNotPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsLancamentoButNotPending());
    }

    private List<Venda> createVendasWithGrupoLancamentoAndIntegracaoIsLancamentoButNotPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.INTEGRADO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsOfAllKindsButNotPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsOfAllKindsButNotPending());
    }

    private List createVendasWithGrupoLancamentoAndIntegracaoIsOfAllKindsButNotPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.INTEGRADO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_LANCAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_SIST_PAGAMENTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsImpostoButNotPending() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsImpostoButNotPending());
    }

    private List<Venda> createVendasWithGrupoLancamentoAndIntegracaoIsImpostoButNotPending() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.INTEGRADO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, IntegracaoTipo.INTEGRACAO_IMPOSTO, IntegracaoStatus.INTEGRADO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndIntegracaoIsNotImpostoNorLancamentoNorPagamento() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndIntegracaoIsNotImpostoNorLancamentoNorPagamento());
    }

    private List<Venda> createVendasWithGrupoLancamentoAndIntegracaoIsNotImpostoNorLancamentoNorPagamento() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndIntegracao(1L, 4l, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndIntegracao(1L, 4l, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndIntegracao(1L, 4l, IntegracaoStatus.AGUARDANDO_INTEGRACAO));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private Set<GrupoLancamento> createGrupoLancamentoAndIntegracao(final long id, final long integration, final long statusId) {

        GLancIntegracao gLancIntegracao = new GLancIntegracao();
        gLancIntegracao.setId(id);
        gLancIntegracao.setIntegracaoTipoId(integration);
        gLancIntegracao.setStatusId(statusId);

        Set<GrupoLancamento> grupoLancamentos = new HashSet<>();
        GrupoLancamento gl = new GrupoLancamento();
        gl.setId(id);
        gl.setIntegracoes(new HashSet(Arrays.asList(new GLancIntegracao[] { gLancIntegracao })));
        grupoLancamentos.add(gl);

        return grupoLancamentos;
    }

    private void verifyOnceSendWinnerNotification(final Long offerId) throws Exception {
        verify(notificationService, times(1)).sendWinnerNotification(offerId);
    }

    private void verifyNeverSendWinnerNotification(final Long offerId) throws Exception {
        verify(notificationService, never()).sendWinnerNotification(offerId);
    }

    private void createEmptyListOfVendas() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                new ArrayList<Venda>());
    }

    private void createListOfVendasWithNoGrupoLancamento() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithNoGrupoLancamento());
    }

    private List<Venda> createVendasWithNoGrupoLancamento() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, new HashSet<GrupoLancamento>());
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, new HashSet<GrupoLancamento>());
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, new HashSet<GrupoLancamento>());
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createListOfVendasWithGrupoLancamentoAndNoGrupoLancamentoIntegracao() {
        createDirectSalesQueryResultList(Venda.Queries.FIND_AUCTION_DIRECT_SALES_WITH_PENDING_NOTIFICATIONS,
                createVendasWithGrupoLancamentoAndNoGrupoLancamentoIntegracao());
    }

    private List createVendasWithGrupoLancamentoAndNoGrupoLancamentoIntegracao() {

        List<Venda> vendas = new ArrayList<>();
        Venda venda = venda(1L, 1L, createGrupoLancamentoAndNoGrupoLancamentoIntegracao(1L));
        Auction auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(2L, 2L, createGrupoLancamentoAndNoGrupoLancamentoIntegracao(2L));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        venda = venda(3L, 3L, createGrupoLancamentoAndNoGrupoLancamentoIntegracao(3L));
        auction = new Auction();
        auction.setAuctionModalityId(1);
        venda.setAuction(auction);
        vendas.add(venda);

        return vendas;
    }

    private void createDirectSalesQueryResultList(String namedQuery, List<Venda> vendas) {
        Query query = mock(Query.class);
        when(query.getResultList()).thenReturn(vendas);
        when(entityManager.createNamedQuery(namedQuery)).thenReturn(query);
    }

    private Set<GrupoLancamento> createGrupoLancamentoAndNoGrupoLancamentoIntegracao(long id) {

        Set<GrupoLancamento> grupoLancamentos = new HashSet<>();
        GrupoLancamento gl = new GrupoLancamento();
        gl.setId(id);
        gl.setIntegracoes(new HashSet(new ArrayList<GLancIntegracao>()));
        grupoLancamentos.add(gl);

        return grupoLancamentos;
    }

    public Venda venda(long id, long ofertaId, Set<GrupoLancamento> grupoLancamentos) {
        Venda venda = new Venda();
        venda.setId(id);
        venda.setOfertaId(ofertaId);
        venda.setGrupoLancamentos(grupoLancamentos);
        return venda;
    }

}
