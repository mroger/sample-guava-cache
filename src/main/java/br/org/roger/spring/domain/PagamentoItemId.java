package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ailson.moreira on 13/04/2017.
 */
@Embeddable
@SuppressWarnings("serial")
public class PagamentoItemId implements Serializable {

    @Column(name = "COD_PAGAMENTO", nullable = false, precision = 9)
    private Long pagamentoId;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, precision = 9)
    private Long grupoLancamentoId;

    public PagamentoItemId(Long pagamentoId, Long grupoLancamentoId) {
        this.pagamentoId = pagamentoId;
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagamentoItemId that = (PagamentoItemId) o;

        if (pagamentoId != null ? !pagamentoId.equals(that.pagamentoId) : that.pagamentoId != null) return false;
        return grupoLancamentoId != null ? grupoLancamentoId.equals(that.grupoLancamentoId) : that.grupoLancamentoId == null;

    }

    @Override
    public int hashCode() {
        int result = pagamentoId != null ? pagamentoId.hashCode() : 0;
        result = 31 * result + (grupoLancamentoId != null ? grupoLancamentoId.hashCode() : 0);
        return result;
    }
}
