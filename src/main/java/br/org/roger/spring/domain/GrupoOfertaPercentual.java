package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by duda on 01/03/2017.
 *
 * Apesar do nome da tabela COMISSAO , na verdade ela eh utilizada para qualquer tipo de VALOR EM PERCENTUAL
 * exemplo:  multas, comissoes, etc... O Nome da tabela nao foi refatorado para evitar o impacto.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GRUPO_OFERTA_COMISSAO")
@NamedQueries({
        @NamedQuery(name = GrupoOfertaPercentual.Queries.FIND_GRUPO_OFERTA_COMISSAO,
                query =
                        " SELECT gp " +
                                " FROM GrupoOfertaPercentual gp " +
                                " WHERE gp.id.grupoOfertaId = :groupOfferId"
        )
})
public class GrupoOfertaPercentual implements Serializable {

    public static final class Queries {
        public static final String FIND_GRUPO_OFERTA_COMISSAO = "FIND_GRUPO_OFERTA_COMISSAO";
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "grupoOfertaId", column = @Column(name = "COD_GRUPO_OFERTA", nullable = false, precision = 9, scale = 0)),
            @AttributeOverride(name = "codTipoItemPagamento", column = @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, precision = 2, scale = 0)) })
    private GrupoOfertaItemPagamentoId id;

    @Column(name = "COMISSAO", precision = 15, scale = 3)
    private BigDecimal comissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private TipoItemPagamento tipoItemPagamento;


    public GrupoOfertaItemPagamentoId getId() {
        return id;
    }

    public void setId(GrupoOfertaItemPagamentoId id) {
        this.id = id;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public TipoItemPagamento getTipoItemPagamento() {
        return tipoItemPagamento;
    }

    public void setTipoItemPagamento(TipoItemPagamento tipoItemPagamento) {
        this.tipoItemPagamento = tipoItemPagamento;
    }
}