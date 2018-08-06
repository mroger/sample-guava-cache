package br.org.roger.spring.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ailson on 05/12/2016.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "FL_GRUPO_LANCAMENTO_BAIXAS")
@NamedQueries({
        @NamedQuery(name = GrupoLancamentoBaixas.Queries.FIND_BAIXAS_BY_ENTRY_GROUP,
                query =
                        " SELECT " +
                                " glb " +
                                " FROM " +
                                " GrupoLancamentoBaixas glb" +
                                " WHERE " +
                                "    glb.id.codGrupoLancamento = :grupoLancamentoId "
        ),
        @NamedQuery(name = GrupoLancamentoBaixas.Queries.DELETE_BAIXAS_BY_ENTRY_GROUP,
        query =
                " DELETE " +
                        " FROM " +
                        " GrupoLancamentoBaixas glb" +
                        " WHERE " +
                        "    glb.id.codGrupoLancamento = :grupoLancamentoId "
)
})
public class GrupoLancamentoBaixas implements Serializable {

    public static final class Queries {
        public static final String FIND_BAIXAS_BY_ENTRY_GROUP = "FIND_BAIXAS_BY_ENTRY_GROUP";
        public static final String DELETE_BAIXAS_BY_ENTRY_GROUP = "DELETE_BAIXAS_BY_ENTRY_GROUP";
    }

    @Id
    private GrupoLancamentoBaixasId id;

    @Column(name = "VALOR_ORIGINAL", precision = 15, scale = 3)
    private BigDecimal valorOriginal;

    @Column(name = "VALOR_BAIXA", precision = 15, scale = 3)
    private BigDecimal valorBaixa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_BAIXA", columnDefinition = "date")
    private Date dataBaixa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CANCELAMENTO_BAIXA", columnDefinition = "date")
    private Date dataCancelBaixa;

    @Column(name = "ATIVO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseCharType")
    private Boolean ativo;


    public GrupoLancamentoBaixasId getId() {
        return id;
    }

    public void setId(GrupoLancamentoBaixasId id) {
        this.id = id;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorBaixa() {
        return valorBaixa;
    }

    public void setValorBaixa(BigDecimal valorBaixa) {
        this.valorBaixa = valorBaixa;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Date getDataCancelBaixa() {
        return dataCancelBaixa;
    }

    public void setDataCancelBaixa(Date dataCancelBaixa) {
        this.dataCancelBaixa = dataCancelBaixa;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}