package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedQueries;
import java.io.Serializable;

/**
 * Created by ailson.moreira on 15/09/2015.
 */

@SuppressWarnings("serial")
@Embeddable
@NamedQueries({})
public class GrupoOfertaItemPagamentoId implements Serializable {

    public static final class Queries {
    }

    @Column(name = "COD_GRUPO_OFERTA", nullable = false)
    private Long grupoOfertaId;

    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false)
    private Long codTipoItemPagamento;

    public GrupoOfertaItemPagamentoId() {
        super();
    }

    public GrupoOfertaItemPagamentoId(Long grupoOfertaId, Long codTipoItemPagamento) {
        super();
        this.grupoOfertaId = grupoOfertaId;
        this.codTipoItemPagamento = codTipoItemPagamento;
    }

    public Long getGrupoOfertaId() {
        return grupoOfertaId;
    }

    public void setGrupoOfertaId(Long grupoOfertaId) {
        this.grupoOfertaId = grupoOfertaId;
    }

    public Long getCodTipoItemPagamento() {
        return codTipoItemPagamento;
    }

    public void setCodTipoItemPagamento(Long codTipoItemPagamento) {
        this.codTipoItemPagamento = codTipoItemPagamento;
    }
}
