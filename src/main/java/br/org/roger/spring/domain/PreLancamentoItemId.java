package br.org.roger.spring.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedQueries;
import java.io.Serializable;

/**
 * Created by ailson.moreira on 15/09/2015.
 */

@SuppressWarnings("serial")
@Embeddable
@EqualsAndHashCode
@NamedQueries({})
public class PreLancamentoItemId implements Serializable {

    public static final class Queries {
    }

    @Column(name = "COD_PRE_LANCAMENTO", nullable = false)
    private Long codPreLancamentoId;

    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false)
    private Long codTipoItemPagamento;

    public PreLancamentoItemId() {
        super();
    }

    public PreLancamentoItemId(Long codPreLancamentoId, Long codTipoItemPagamento) {
        super();
        this.codPreLancamentoId = codPreLancamentoId;
        this.codTipoItemPagamento = codTipoItemPagamento;
    }

    public Long getCodPreLancamentoId() {
        return codPreLancamentoId;
    }

    public void setCodPreLancamentoId(Long codPreLancamentoId) {
        this.codPreLancamentoId = codPreLancamentoId;
    }

    public Long getCodTipoItemPagamento() {
        return codTipoItemPagamento;
    }

    public void setCodTipoItemPagamento(Long codTipoItemPagamento) {
        this.codTipoItemPagamento = codTipoItemPagamento;
    }
}
