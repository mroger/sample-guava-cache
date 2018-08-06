package br.org.roger.spring.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ailson on 27/12/2016.
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "FL_TRIBUTO_LANCAMENTO")
@NamedQueries({
        @NamedQuery(
            name=TributoLancamento.Queries.FIND_TRIBUTOS_POR_GRUPO_LANCAMENTO,
            query = " select t " +
                    " from TributoLancamento t " +
                    " inner join t.tipoItemPagto ti " +
                    " where t.grupoLancamentoId = :grupoLancamentoId "
        ),
        @NamedQuery(
                name=TributoLancamento.Queries.FIND_TRIBUTOS_POR_DESC_TIPO_ITEM,
                query = "select t from TributoLancamento t join fetch t.tipoItemPagto ti where t.grupoLancamentoId = :entryGroupId and t.tributoDesc = :taxDesc and t.tipoItemPagtoId = :itemTypeId"
        ),
        @NamedQuery(
                name=TributoLancamento.Queries.FIND_TRIBUTOS_BY_ENTRY_GROUP_AND_TYPE,
                query = "select t from TributoLancamento t join fetch t.tipoItemPagto ti where t.grupoLancamentoId = :entryGroupId and t.tipoItemPagtoId = :itemTypeId"
        )
})
public class TributoLancamento implements Serializable {

    public static final class Queries {
        public static final String FIND_TRIBUTOS_POR_GRUPO_LANCAMENTO = "FIND_TRIBUTOS_POR_GRUPO_LANCAMENTO";
        public static final String FIND_TRIBUTOS_POR_DESC_TIPO_ITEM = "FIND_TRIBUTOS_POR_DESC_TIPO_ITEM";
        public static final String FIND_TRIBUTOS_BY_ENTRY_GROUP_AND_TYPE = "FIND_TRIBUTOS_BY_ENTRY_GROUP_AND_TYPE";
    }

    public static final String IRRFPJ = "IRRFPJ";
    public static final String CSLLRF = "CSLLRF";
    public static final String PISRF  = "PISRF";
    public static final String COFRF  = "COFRF";

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_TRIBUTO", nullable = false, precision = 9)
    private Long id;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, precision = 9)
    private Long grupoLancamentoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    @Column(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, precision = 2)
    private Long tipoItemPagtoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_TIPO_ITEM_PAGAMENTO", nullable = false, insertable = false, updatable = false)
    private TipoItemPagamento tipoItemPagto;

    @Column(name = "TRIBUTO_DESC", precision = 10)
    private String tributoDesc;

    @Formula("UPPER(REGEXP_REPLACE(TRIBUTO_DESC, '[^a-zA-Z]', ''))")
    private String tributoDescCaseInsensitive;

    @Column(name = "TRIBUTO_VALOR", precision = 15, scale = 3)
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }

    public Long getTipoItemPagtoId() {
        return tipoItemPagtoId;
    }

    public void setTipoItemPagtoId(Long tipoItemPagtoId) {
        this.tipoItemPagtoId = tipoItemPagtoId;
    }

    public TipoItemPagamento getTipoItemPagto() {
        return tipoItemPagto;
    }

    public void setTipoItemPagto(TipoItemPagamento tipoItemPagto) {
        this.tipoItemPagto = tipoItemPagto;
    }

    public String getTributoDesc() {
        return tributoDesc;
    }

    public void setTributoDesc(String tributoDesc) {
        this.tributoDesc = tributoDesc;
    }

    public String getTributoDescCaseInsensitive() {
        return tributoDescCaseInsensitive;
    }

    public void setTributoDescCaseInsensitive(String tributoDescCaseInsensitive) {
        this.tributoDescCaseInsensitive = tributoDescCaseInsensitive;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
