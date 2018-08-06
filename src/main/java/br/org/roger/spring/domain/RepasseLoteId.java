package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chen on 17/09/2015.
 */
@SuppressWarnings("serial")
@Embeddable
public class RepasseLoteId implements Serializable {

    @Column(name = "COD_REPASSE", nullable = false)
    private Long repasseId;

    @Column(name = "COD_OFERTA", nullable = false)
    private Long offerId;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false)
    private Long grupoLancamentoId;

    public RepasseLoteId() {
    }

    public RepasseLoteId(Long repasseId, Long offerId, Long grupoLancamentoId) {
        this.repasseId = repasseId;
        this.offerId = offerId;
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public Long getRepasseId() {
        return repasseId;
    }

    public void setRepasseId(Long repasseId) {
        this.repasseId = repasseId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }
}
