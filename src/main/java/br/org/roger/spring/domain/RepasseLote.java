package br.org.roger.spring.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by chen on 17/09/2015.
 */
@Entity
@Table(name = "FL_REPASSE_LOTE")
public class RepasseLote {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "repasseId", column = @Column(name = "COD_REPASSE", nullable = false, precision = 9, scale = 0)),
            @AttributeOverride(name = "offerId", column = @Column(name = "COD_OFERTA", nullable = false, precision = 9, scale = 0)),
            @AttributeOverride(name = "grupoLancamentoId", column = @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, precision = 9, scale = 0)) })
    private RepasseLoteId id;

    @Column(name = "VALOR_LOTE", precision = 15, scale = 3)
    private BigDecimal valorLote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_REPASSE", nullable = false, insertable = false, updatable = false)
    private Repasse repasse;


    public RepasseLoteId getId() {
        return id;
    }

    public void setId(RepasseLoteId id) {
        this.id = id;
    }

    public BigDecimal getValorLote() {
        return valorLote;
    }

    public void setValorLote(BigDecimal valorLote) {
        this.valorLote = valorLote;
    }

    public Repasse getRepasse() {
        return repasse;
    }

    public void setRepasse(Repasse repasse) {
        this.repasse = repasse;
    }

}
