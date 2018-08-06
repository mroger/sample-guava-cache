package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ailson.moreira on 13/04/2017.
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "FL_PAGAMENTO_ITEM")
public class PagamentoItem implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "pagamentoId", column = @Column(name = "COD_PAGAMENTO", nullable = false)),
            @AttributeOverride(name = "grupoLancamentoId", column = @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false))})
    private PagamentoItemId id;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false, precision = 9)
    private Long grupoLancamentoId;

    @Column(name = "COD_PAGAMENTO", nullable = false, insertable = false, updatable = false, precision = 9)
    private Long pagamentoId;

    @ManyToOne
    @JoinColumn(name = "COD_GRUPO_LANCAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    public PagamentoItemId getId() {
        return id;
    }

    public void setId(PagamentoItemId id) {
        this.id = id;
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

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }
}
