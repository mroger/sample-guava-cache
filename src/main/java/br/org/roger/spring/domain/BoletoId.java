package br.org.roger.spring.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by chen on 02/08/2016.
 */
@SuppressWarnings("serial")
@Embeddable
public class BoletoId implements Serializable {

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false)
    private Long grupoLancamentoId;

    @Column(name = "QUANTIDADE_PRORROGACAO", nullable = false)
    private Integer quantidadeProrrogacao;

    public BoletoId() {
    }

    public BoletoId(Long grupoLancamentoId, Integer quantidadeProrrogacao) {
        this.grupoLancamentoId = grupoLancamentoId;
        this.quantidadeProrrogacao = quantidadeProrrogacao;
    }

    public Long getGrupoLancamentoId() {
        return grupoLancamentoId;
    }

    public void setGrupoLancamentoId(Long grupoLancamentoId) {
        this.grupoLancamentoId = grupoLancamentoId;
    }

    public Integer getQuantidadeProrrogacao() {
        return quantidadeProrrogacao;
    }

    public void setQuantidadeProrrogacao(Integer quantidadeProrrogacao) {
        this.quantidadeProrrogacao = quantidadeProrrogacao;
    }
}
