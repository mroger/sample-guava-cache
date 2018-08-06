package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by chen on 16/09/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Fl_LANCAMENTO")
public class Lancamento implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "grupoLancamentoId", column = @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, precision = 9, scale = 0)),
            @AttributeOverride(name = "tipoItemPagamentoId", column = @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, precision = 2, scale = 0)) })
    private LancamentoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private TipoItemPagamento tipoItemPagamento;

    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", precision = 2, scale = 0, insertable = false, updatable = false)
    private Long tipoItemPagamentoId;

    @Column(name = "VALOR_ITEM", precision = 15, scale = 3)
    private BigDecimal valorItem;

    @Column(name = "VALOR_IMPOSTO", precision = 15, scale = 3)
    private BigDecimal valorImposto;

    @Column(name = "COD_STATUS_LANCAMENTO", precision = 2, scale = 0)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_LANCAMENTO", insertable = false, updatable = false)
    private LancamentoStatus lancamentoStatus;

    @Column(name = "VALOR_ITEM_TOTAL", precision = 15, scale = 3)
    private BigDecimal valorItemTotal;

    public LancamentoId getId() {
        return id;
    }

    public void setId(LancamentoId id) {
        this.id = id;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }

    public TipoItemPagamento getTipoItemPagamento() {
        return tipoItemPagamento;
    }

    public void setTipoItemPagamento(TipoItemPagamento tipoItemPagamento) {
        this.tipoItemPagamento = tipoItemPagamento;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }

    public BigDecimal getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(BigDecimal valorImposto) {
        this.valorImposto = valorImposto;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LancamentoStatus getLancamentoStatus() {
        return lancamentoStatus;
    }

    public void setLancamentoStatus(LancamentoStatus lancamentoStatus) {
        this.lancamentoStatus = lancamentoStatus;
    }

    public BigDecimal getValorItemTotal() {
        return valorItemTotal;
    }

    public void setValorItemTotal(BigDecimal valorItemTotal) {
        this.valorItemTotal = valorItemTotal;
    }

    public Long getTipoItemPagamentoId() {
        return tipoItemPagamentoId;
    }

    public void setTipoItemPagamentoId(Long tipoItemPagamentoId) {
        this.tipoItemPagamentoId = tipoItemPagamentoId;
    }
}
