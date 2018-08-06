package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by selma on 17/11/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GRUPO_REPASSE")

@NamedQueries({
        @NamedQuery(name = GrupoRepasse.Queries.FIND_GRUPO_REPASSE_FORMA_PAG,
            query =
                " SELECT " +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.PaymentMethodDTO( " +
                        "     rf.id, " +
                        "     rf.desc, " +
                        "     rf.sigla) " +
                        " FROM " +
                        "      GrupoRepasse gp " +
                        "      inner join gp.repasseFormaPagamento rf " +
                        " WHERE " +
                        "      gp.auctionId = :qAuctionId " +
                        "  and gp.comitenteId = :qSellerId "
        ),

        @NamedQuery(name = GrupoRepasse.Queries.FIND_GRUPO_REPASSE_CONTA,
            query =
                    " SELECT " +
                            " new net.s4bdigital.api.auctionfinancial.server.domain.dto.BankAccountDTO( " +
                            "   e.name, " +
                            "   co.id, " +
                            "   b.numero, " +
                            "   b.nome, " +
                            "   co.agencia, " +
                            "   co.agenciaDigito, " +
                            "   co.conta, " +
                            "   co.contaDigito) " +
                            " FROM " +
                            "   GrupoRepasse gp " +
                            "   inner join gp.conta co " +
                            "   inner join co.banco b " +
                            "   inner join co.userEntity e" +
                            " WHERE " +
                            "       gp.auctionId = :qAuctionId " +
                            "   and gp.comitenteId = :qSellerId "
        ),

        @NamedQuery(name = GrupoRepasse.Queries.FIND_GRUPO_REPASSE_FAVORECIDO,
            query =
                    " SELECT " +
                            "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.SellerDTO( " +
                            "     ue.id, " +
                            "     ue.name, " +
                            "     ue.entityType, " +
                            "     l.loginName, " +
                            "     d.numero, " +
                            "     dt.id, " +
                            "     dt.name) " +
                            " FROM " +
                            "   GrupoRepasse gp " +
                            "   inner join gp.conta co " +
                            "	inner join co.userEntity ue " +
                            "	inner join ue.login l " +
                            "	inner join ue.documents d " +
                            "	inner join d.documentType dt " +
                            " WHERE " +
                            "       gp.auctionId = :qAuctionId " +
                            "   and gp.comitenteId = :qSellerId " +
                            "   and ( ( ue.entityType = 'J' AND dt.id = " + DocumentType.CNPJ + " ) " +
                            "           OR  " +
                            "         ( ue.entityType = 'F' AND dt.id = " + DocumentType.CPF + " ) ) "

    )
})
public class GrupoRepasse implements Serializable {

    public static final class Queries {
        public static final String FIND_GRUPO_REPASSE_FORMA_PAG = "FIND_GRUPO_REPASSE_FORMA_PAG";
        public static final String FIND_GRUPO_REPASSE_CONTA = "FIND_GRUPO_REPASSE_CONTA";
        public static final String FIND_GRUPO_REPASSE_FAVORECIDO = "FIND_GRUPO_REPASSE_FAVORECIDO";
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_GRUPO_REPASSE", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "NOME_GRUPO_REPASSE", nullable = false, length = 100)
    private String nomeGrupoRepasse;

    @Column(name = "COD_LEILAO", precision = 9, scale = 0)
    private Long auctionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_LEILAO", insertable = false, updatable = false)
    private Auction auction;

    @Column(name = "COD_COMITENTE", precision = 9, scale = 0)
    private Long comitenteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_COMITENTE", insertable = false, updatable = false)
    private UserEntity comitente;

    @Column(name = "COD_FORMA_PAGAMENTO", precision = 1, scale = 0)
    private Integer formaPagamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_FORMA_PAGAMENTO", insertable = false, updatable = false)
    private RepasseFormaPag repasseFormaPagamento;

    @Column(name = "COD_CONTA", precision = 9, scale = 0)
    private Long contaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA", insertable = false, updatable = false)
    private Conta conta;

    @Column(name = "COD_ABERTURA_COMITENTE", precision = 9, scale = 0)
    private Long aberturaComitenteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ABERTURA_COMITENTE", insertable = false, updatable = false)
    private AberturaComitente aberturaComitente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ALTERACAO", columnDefinition = "date")
    private Date dataAlteracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrupoRepasse() {
        return nomeGrupoRepasse;
    }

    public void setNomeGrupoRepasse(String nomeGrupoRepasse) {
        this.nomeGrupoRepasse = nomeGrupoRepasse;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Long getComitenteId() {
        return comitenteId;
    }

    public void setComitenteId(Long comitenteId) {
        this.comitenteId = comitenteId;
    }

    public UserEntity getComitente() {
        return comitente;
    }

    public void setComitente(UserEntity comitente) {
        this.comitente = comitente;
    }

    public Integer getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(Integer formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public RepasseFormaPag getRepasseFormaPagamento() {
        return repasseFormaPagamento;
    }

    public void setRepasseFormaPagamento(RepasseFormaPag repasseFormaPagamento) {
        this.repasseFormaPagamento = repasseFormaPagamento;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Long getAberturaComitenteId() {
        return aberturaComitenteId;
    }

    public void setAberturaComitenteId(Long aberturaComitenteId) {
        this.aberturaComitenteId = aberturaComitenteId;
    }

    public AberturaComitente getAberturaComitente() {
        return aberturaComitente;
    }

    public void setAberturaComitente(AberturaComitente aberturaComitente) {
        this.aberturaComitente = aberturaComitente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
