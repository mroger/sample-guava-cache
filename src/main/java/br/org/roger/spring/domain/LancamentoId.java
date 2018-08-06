package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chen on 16/09/2015.
 */
@SuppressWarnings("serial")
@Embeddable
public class LancamentoId implements Serializable {

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false)
    private Long grupoLancamentoId;

    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false)
    private Integer tipoItemPagamentoId;

    public LancamentoId() {
    }

    public LancamentoId(Long grupoLancamentoId, Integer tipoItemPagamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
        this.tipoItemPagamentoId = tipoItemPagamentoId;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public Integer getTipoItemPagamentoId() {
        return tipoItemPagamentoId;
    }

    public void setTipoItemPagamentoId(Integer tipoItemPagamentoId) {
        this.tipoItemPagamentoId = tipoItemPagamentoId;
    }
}
