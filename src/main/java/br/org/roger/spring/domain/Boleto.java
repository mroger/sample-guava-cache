package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chen on 02/08/2016.
 */
@Entity
@Table(name = "FL_BOLETO")
@NamedQueries({
        @NamedQuery(name = Boleto.Queries.FIND_LAST_BILLET_INFO,
                query =
                        " SELECT " +
                                " new net.s4bdigital.api.auctionfinancial.server.domain.dto.BillingInformationDTO( " +
                                " b.id.grupoLancamentoId, " +
                                " b.id.quantidadeProrrogacao, " +
                                " b.nossoNumero, " +
                                " b.numDoc, " +
                                " b.dataProcessamento, " +
                                " b.dataAlteracao, " +
                                " b.dataVencBoleto," +
                                " b.valorBruto " +
                                " ) " +
                                " FROM " +
                                " Boleto b" +
                                " WHERE " +
                                "     b.id.grupoLancamentoId = :grupoLancamentoId " +
                                " AND b.id.quantidadeProrrogacao = (SELECT MAX(b2.id.quantidadeProrrogacao) FROM Boleto b2 WHERE b2.id.grupoLancamentoId = :grupoLancamentoId)"
        ),
        @NamedQuery(name = Boleto.Queries.GET_LAST_DEFERRED_NUMBER,
                query = "SELECT MAX(b2.id.quantidadeProrrogacao) FROM Boleto b2 WHERE b2.id.grupoLancamentoId = :grupoLancamentoId"
        )
})
public class Boleto implements Serializable {

    public static final class Queries {
        public static final String FIND_LAST_BILLET_INFO    = "FIND_LAST_BILLET_INFO";
        public static final String GET_LAST_DEFERRED_NUMBER = "GET_LAST_DEFERRED_NUMBER";
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "grupoLancamentoId", column = @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false)),
            @AttributeOverride(name = "quantidadeProrrogacao", column = @Column(name = "QUANTIDADE_PRORROGACAO", nullable = false))})
    private BoletoId id;

    @Column(name = "NOSSO_NUMERO")
    private String nossoNumero;

    @Column(name = "NUMERO_DOCUMENTO", precision = 12)
    private String numDoc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_PROCESSAMENTO", columnDefinition = "date")
    private Date dataProcessamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ALTERACAO", columnDefinition = "date")
    private Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_VENCIMENTO_BOLETO", columnDefinition = "date")
    private Date dataVencBoleto;

    @Column(name = "VALOR_BRUTO", precision = 15, scale = 3)
    private BigDecimal valorBruto;

    @Column(name = "VALOR_IR", precision = 15, scale = 3)
    private BigDecimal irValue;

    @Column(name = "VALOR_CSLL", precision = 15, scale = 3)
    private BigDecimal csllValue;

    @Column(name = "VALOR_PIS", precision = 15, scale = 3)
    private BigDecimal pisValue;

    @Column(name = "VALOR_COFINS", precision = 15, scale = 3)
    private BigDecimal cofinsValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    @Column(name = "COD_GRUPO_LANCAMENTO", insertable = false, updatable = false)
    private Long grupoLancamentoId;

    public BoletoId getId() {
        return id;
    }

    public void setId(BoletoId id) {
        this.id = id;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataVencBoleto() {
        return dataVencBoleto;
    }

    public void setDataVencBoleto(Date dataVencBoleto) {
        this.dataVencBoleto = dataVencBoleto;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getIrValue() {
        return irValue;
    }

    public void setIrValue(BigDecimal irValue) {
        this.irValue = irValue;
    }

    public BigDecimal getCsllValue() {
        return csllValue;
    }

    public void setCsllValue(BigDecimal csllValue) {
        this.csllValue = csllValue;
    }

    public BigDecimal getPisValue() {
        return pisValue;
    }

    public void setPisValue(BigDecimal pisValue) {
        this.pisValue = pisValue;
    }

    public BigDecimal getCofinsValue() {
        return cofinsValue;
    }

    public void setCofinsValue(BigDecimal cofinsValue) {
        this.cofinsValue = cofinsValue;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }
}
