package br.org.roger.spring.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by chen on 16/09/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Fl_GRUPO_LANCAMENTO")
@NamedQuery(name = GrupoLancamento.Queries.FIND_GRUPO_LANCAMENTO_ULTIMA_GERACAO,
        query = " select gl from GrupoLancamento gl where gl.origemId = :preLancamentoId and gl.sequenceOrigem = gl" +
                ".sequenceUltimaGeracao "
)
public class GrupoLancamento implements Serializable {

    public static final Integer ABERTO = 1;
    public static final Integer BAIXADO = 2;
    public static final Integer CANCELADO = 3;
    public static final Integer SOLICITACAO_DEVOLUCAO_ERP = 4;
    public static final Integer CANCELADO_ERP = 5;

    public static final class Queries {
        public static final String FIND_GRUPO_LANCAMENTO_ULTIMA_GERACAO = "FIND_GRUPO_LANCAMENTO_ULTIMA_GERACAO";
    }

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_GRUPO_LANCAMENTO")
    private Long id;

    @Column(name = "COD_STATUS_GRUPO_LANCAMENTO", precision = 2, scale = 0)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_GRUPO_LANCAMENTO", insertable = false, updatable = false)
    private GrupoLancamentoStatus grupoLancamentoStatus;

    @Column(name = "COD_STATUS_INTEGRACAO", precision = 2)
    private Long statusIntegracaoId;

    @Column(name = "COD_ENTIDADE_RECEBER", precision = 9, scale = 0)
    private Long entidadeReceberId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PROGRAMADA", columnDefinition = "date")
    private Date dataProgramada;

    @Column(name = "COD_ORIGEM", nullable = false)
    private Long origemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ORIGEM", nullable = false, insertable = false, updatable = false)
    private PreLancamento preLancamento;

    @Column(name = "SEQUENCE_ORIGEM")
    private Integer sequenceOrigem;

    @Column(name = "COD_ORIGEM_LANCAMENTO")
    private Integer origemLancamentoId;

    @Column(name = "COD_ENTIDADE_PAGAR", precision = 9, scale = 0)
    private Long entidadePagarId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_ENTIDADE_PAGAR", insertable = false, updatable = false)
    private UserEntity comprador;

    @Column(name = "COD_NOTA_ARREMATACAO", precision = 9, scale = 0)
    private Long notaArrematacaoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_NOTA_ARREMATACAO", nullable = false, insertable = false, updatable = false)
    private NotaArrematacao notaArrematacao;

    @Column(name = "INSTRUCAO_PAGAMENTO")
    private String instrucaoPagamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PAGAMENTO", columnDefinition = "date")
    private Date dataPagamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_EMISSAO", columnDefinition = "date")
    private Date dataEmissao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_VENCIMENTO", columnDefinition = "date")
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_APROVACAO", columnDefinition = "date")
    private Date dataAprovacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_REPASSE", columnDefinition = "date")
    private Date dataRepasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CANCELAMENTO", columnDefinition = "date")
    private Date dataCancelamento;

    @Column(name = "COD_VENDA")
    private Long vendaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_VENDA", insertable = false, updatable = false)
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CONTA_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private ContaPagamento contaPagamento;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private Deposito deposito;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private CancelamentoHistorico cancelamentoHistorico;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private Set<Lancamento> lancamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private Set<Boleto> boleto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private Set<GLancIntegracao> integracoes;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "entryGroups")
    private Set<Pagamento> pagamentos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoLancamento")
    private Set<PagamentoItem> pagamentoItem;

    @Formula(value = "(SELECT MAX(G2.SEQUENCE_ORIGEM) FROM FL_GRUPO_LANCAMENTO G2 WHERE G2.COD_ORIGEM = COD_ORIGEM)")
    private Long sequenceUltimaGeracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public GrupoLancamentoStatus getGrupoLancamentoStatus() {
        return grupoLancamentoStatus;
    }

    public void setGrupoLancamentoStatus(GrupoLancamentoStatus grupoLancamentoStatus) {
        this.grupoLancamentoStatus = grupoLancamentoStatus;
    }

    public Long getStatusIntegracaoId() {
        return statusIntegracaoId;
    }

    public void setStatusIntegracaoId(Long statusIntegracaoId) {
        this.statusIntegracaoId = statusIntegracaoId;
    }

    public Long getEntidadeReceberId() {
        return entidadeReceberId;
    }

    public void setEntidadeReceberId(Long entidadeReceberId) {
        this.entidadeReceberId = entidadeReceberId;
    }

    public Date getDataProgramada() {
        return dataProgramada;
    }

    public void setDataProgramada(Date dataProgramada) {
        this.dataProgramada = dataProgramada;
    }

    public Long getOrigemId() {
        return origemId;
    }

    public void setOrigemId(Long origemId) {
        this.origemId = origemId;
    }

    public PreLancamento getPreLancamento() {
        return preLancamento;
    }

    public void setPreLancamento(PreLancamento preLancamento) {
        this.preLancamento = preLancamento;
    }

    public Integer getSequenceOrigem() {
        return sequenceOrigem;
    }

    public void setSequenceOrigem(Integer sequenceOrigem) {
        this.sequenceOrigem = sequenceOrigem;
    }

    public Integer getOrigemLancamentoId() {
        return origemLancamentoId;
    }

    public void setOrigemLancamentoId(Integer origemLancamentoId) {
        this.origemLancamentoId = origemLancamentoId;
    }

    public Long getEntidadePagarId() {
        return entidadePagarId;
    }

    public void setEntidadePagarId(Long entidadePagarId) {
        this.entidadePagarId = entidadePagarId;
    }

    public Long getNotaArrematacaoId() {
        return notaArrematacaoId;
    }

    public void setNotaArrematacaoId(Long notaArrematacaoId) {
        this.notaArrematacaoId = notaArrematacaoId;
    }

    public NotaArrematacao getNotaArrematacao() {
        return notaArrematacao;
    }

    public void setNotaArrematacao(NotaArrematacao notaArrematacao) {
        this.notaArrematacao = notaArrematacao;
    }

    public String getInstrucaoPagamento() {
        return instrucaoPagamento;
    }

    public void setInstrucaoPagamento(String instrucaoPagamento) {
        this.instrucaoPagamento = instrucaoPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Date getDataRepasse() {
        return dataRepasse;
    }

    public void setDataRepasse(Date dataRepasse) {
        this.dataRepasse = dataRepasse;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ContaPagamento getContaPagamento() {
        return contaPagamento;
    }

    public void setContaPagamento(ContaPagamento contaPagamento) {
        this.contaPagamento = contaPagamento;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public CancelamentoHistorico getCancelamentoHistorico() {
        return cancelamentoHistorico;
    }

    public void setCancelamentoHistorico(CancelamentoHistorico cancelamentoHistorico) {
        this.cancelamentoHistorico = cancelamentoHistorico;
    }

    public Set<Lancamento> getLancamento() {
        return lancamento;
    }

    public void setLancamento(Set<Lancamento> lancamento) {
        this.lancamento = lancamento;
    }

    public Set<Boleto> getBoleto() {
        return boleto;
    }

    public void setBoleto(Set<Boleto> boleto) {
        this.boleto = boleto;
    }

    public Set<GLancIntegracao> getIntegracoes() {
        return integracoes;
    }

    public void setIntegracoes(Set<GLancIntegracao> integracoes) {
        this.integracoes = integracoes;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Long getSequenceUltimaGeracao() {
        return sequenceUltimaGeracao;
    }

    public void setSequenceUltimaGeracao(Long sequenceUltimaGeracao) {
        this.sequenceUltimaGeracao = sequenceUltimaGeracao;
    }

    public Set<PagamentoItem> getPagamentoItem() {
        return pagamentoItem;
    }

    public void setPagamentoItem(Set<PagamentoItem> pagamentoItem) {
        this.pagamentoItem = pagamentoItem;
    }
}