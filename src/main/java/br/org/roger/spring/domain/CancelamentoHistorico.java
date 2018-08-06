package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * Created by chen on 02/08/2016.
 */
@Entity
@Table(name = "FL_CANCELAMENTO_HISTORICO")
public class CancelamentoHistorico {

    @Id
    @Column(name = "COD_HISTORICO_CANCELAMENTO", unique = true, nullable = false, precision = 9, scale = 0)
    private Long id;

    @Column(name = "COD_MOTIVO_CANCELAMENTO", nullable = false, precision = 3)
    private Integer motivoCancelamentoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_HISTORICO_CANCELAMENTO", nullable = false, insertable = false, updatable = false)
    private GrupoLancamento grupoLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMotivoCancelamentoId() {
        return motivoCancelamentoId;
    }

    public void setMotivoCancelamentoId(Integer motivoCancelamentoId) {
        this.motivoCancelamentoId = motivoCancelamentoId;
    }

    public GrupoLancamento getGrupoLancamento() {
        return grupoLancamento;
    }

    public void setGrupoLancamento(GrupoLancamento grupoLancamento) {
        this.grupoLancamento = grupoLancamento;
    }
}
