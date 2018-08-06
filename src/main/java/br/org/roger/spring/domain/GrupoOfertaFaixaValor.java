package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by duda on 01/03/2017.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GRUPO_OFERTA_TAXA")
@NamedQueries({})
public class GrupoOfertaFaixaValor implements Serializable {

    public static final class Queries {
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "grupoOfertaId", column = @Column(name = "COD_GRUPO_OFERTA", nullable = false, precision = 9, scale = 0)),
            @AttributeOverride(name = "codTipoItemPagamento", column = @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, precision = 2, scale = 0)) })
    private GrupoOfertaItemPagamentoId id;

    @Column(name = "VALOR_INICIAL", precision = 15, scale = 3)
    private BigDecimal valorInicial;

    @Column(name = "VALOR_FINAL", precision = 15, scale = 3)
    private BigDecimal valorFinal;

    @Column(name = "VALOR_TAXA", precision = 15, scale = 3)
    private BigDecimal valorTaxa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private TipoItemPagamento tipoItemPagamento;


    public GrupoOfertaItemPagamentoId getId() {
        return id;
    }

    public void setId(GrupoOfertaItemPagamentoId id) {
        this.id = id;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(BigDecimal valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public TipoItemPagamento getTipoItemPagamento() {
        return tipoItemPagamento;
    }

    public void setTipoItemPagamento(TipoItemPagamento tipoItemPagamento) {
        this.tipoItemPagamento = tipoItemPagamento;
    }
}