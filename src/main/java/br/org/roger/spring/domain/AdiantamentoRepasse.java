package br.org.roger.spring.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chen on 04/09/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_ADIANTAMENTO_REPASSE")
public class AdiantamentoRepasse implements Serializable {

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_ADIANTAMENTO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

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

    @Column(name = "COD_ENTIDADE_REPASSE", precision = 9, scale = 0)
    private Long entidadeRepasseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ENTIDADE_REPASSE", insertable = false, updatable = false)
    private UserEntity entidadeRepasse;

    @Column(name = "COD_CONTA_REPASSE", precision = 9, scale = 0)
    private Long contaRepasseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA_REPASSE", insertable = false, updatable = false)
    private Conta contaRepasse;

    @Column(name = "COD_FORMA_PAGAMENTO", precision = 1, scale = 0)
    private Integer formaPagamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_FORMA_PAGAMENTO", insertable = false, updatable = false)
    private RepasseFormaPag repasseFormaPagamento;

    @Column(name = "COD_TIPO_TRANSFERENCIA", precision = 1, scale = 0)
    private Integer tipoTransferenciaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_TRANSFERENCIA", insertable = false, updatable = false)
    private RepasseTipoTransf tipoTransferencia;

    @Column(name = "COD_ENTIDADE_ORIGEM", precision = 9, scale = 0)
    private Long entidadeOrigemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ENTIDADE_ORIGEM", insertable = false, updatable = false)
    private UserEntity entidadeOrigem;

    @Column(name = "COD_CONTA_PAGAMENTO_ORIGEM", precision = 9, scale = 0)
    private Long contaPagamentoOrigemId;

    @Column(name = "COD_STATUS_INTEGRACAO", precision = 2, scale = 0)
    private Integer statusIntegracaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_INTEGRACAO", insertable = false, updatable = false)
    private IntegracaoStatus statusIntegracao;

    @Formula("DECODE(COD_STATUS_INTEGRACAO, 4, 1, 0)")
    private Boolean integracao;

    @Column(name = "COD_STATUS", precision = 2, scale = 0)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS", insertable = false, updatable = false)
    private RepasseStatus status;

    @Column(name = "VALOR_ADIANTAMENTO", precision = 15, scale = 3)
    private BigDecimal valorAdiantamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PROGRAMACAO", columnDefinition = "date")
    private Date dataProgramacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_REPASSE", columnDefinition = "date")
    private Date dataRepasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INTEGRACAO", columnDefinition = "date")
    private Date dataIntegracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CANCELAMENTO", columnDefinition = "date")
    private Date dataCancelamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", columnDefinition = "date")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ALTERACAO", columnDefinition = "date")
    private Date dataAlteracao;

    @Column(name = "APROVADO", length = 1)
    @Type(type = "true_false")
    private Boolean aprovado;

    @Column(name = "OBSERVACAO", length = 155)
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getComitenteId() {
        return comitenteId;
    }

    public void setComitenteId(Long comitenteId) {
        this.comitenteId = comitenteId;
    }

    public Long getContaRepasseId() {
        return contaRepasseId;
    }

    public void setContaRepasseId(Long contaRepasseId) {
        this.contaRepasseId = contaRepasseId;
    }

    public Integer getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(Integer formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public Integer getTipoTransferenciaId() {
        return tipoTransferenciaId;
    }

    public void setTipoTransferenciaId(Integer tipoTransferenciaId) {
        this.tipoTransferenciaId = tipoTransferenciaId;
    }

    public Long getEntidadeOrigemId() {
        return entidadeOrigemId;
    }

    public void setEntidadeOrigemId(Long entidadeOrigemId) {
        this.entidadeOrigemId = entidadeOrigemId;
    }

    public Long getContaPagamentoOrigemId() {
        return contaPagamentoOrigemId;
    }

    public void setContaPagamentoOrigemId(Long contaPagamentoOrigemId) {
        this.contaPagamentoOrigemId = contaPagamentoOrigemId;
    }

    public Integer getStatusIntegracaoId() {
        return statusIntegracaoId;
    }

    public void setStatusIntegracaoId(Integer statusIntegracaoId) {
        this.statusIntegracaoId = statusIntegracaoId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public BigDecimal getValorAdiantamento() {
        return valorAdiantamento;
    }

    public void setValorAdiantamento(BigDecimal valorAdiantamento) {
        this.valorAdiantamento = valorAdiantamento;
    }

    public Date getDataProgramacao() {
        return dataProgramacao;
    }

    public void setDataProgramacao(Date dataProgramacao) {
        this.dataProgramacao = dataProgramacao;
    }

    public Date getDataRepasse() {
        return dataRepasse;
    }

    public void setDataRepasse(Date dataRepasse) {
        this.dataRepasse = dataRepasse;
    }

    public Date getDataIntegracao() {
        return dataIntegracao;
    }

    public void setDataIntegracao(Date dataIntegracao) {
        this.dataIntegracao = dataIntegracao;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
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

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Long getEntidadeRepasseId() {
        return entidadeRepasseId;
    }

    public void setEntidadeRepasseId(Long entidadeRepasseId) {
        this.entidadeRepasseId = entidadeRepasseId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public UserEntity getEntidadeRepasse() {
        return entidadeRepasse;
    }

    public void setEntidadeRepasse(UserEntity entidadeRepasse) {
        this.entidadeRepasse = entidadeRepasse;
    }

    public UserEntity getEntidadeOrigem() {
        return entidadeOrigem;
    }

    public void setEntidadeOrigem(UserEntity entidadeOrigem) {
        this.entidadeOrigem = entidadeOrigem;
    }

    public RepasseTipoTransf getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(RepasseTipoTransf tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public IntegracaoStatus getStatusIntegracao() {
        return statusIntegracao;
    }

    public void setStatusIntegracao(IntegracaoStatus statusIntegracao) {
        this.statusIntegracao = statusIntegracao;
    }

    public RepasseStatus getStatus() {
        return status;
    }

    public void setStatus(RepasseStatus status) {
        this.status = status;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Conta getContaRepasse() {
        return contaRepasse;
    }

    public void setContaRepasse(Conta contaRepasse) {
        this.contaRepasse = contaRepasse;
    }

    public Boolean getIntegracao() {
        return integracao;
    }

    public void setIntegracao(Boolean integracao) {
        this.integracao = integracao;
    }

    public UserEntity getComitente() {
        return comitente;
    }

    public void setComitente(UserEntity comitente) {
        this.comitente = comitente;
    }

    public RepasseFormaPag getRepasseFormaPagamento() {
        return repasseFormaPagamento;
    }

    public void setRepasseFormaPagamento(RepasseFormaPag repasseFormaPagamento) {
        this.repasseFormaPagamento = repasseFormaPagamento;
    }
}