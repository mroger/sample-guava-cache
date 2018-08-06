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
public class GrupoLancamentoBaixasId implements Serializable {

    public static final class Queries {
    }

    @Column(name = "COD_BAIXA", nullable = false)
    private Integer codBaixa;

    @Column(name = "COD_GRUPO_LANCAMENTO", nullable = false)
    private Long codGrupoLancamento;

    public GrupoLancamentoBaixasId() {
        super();
    }

    public GrupoLancamentoBaixasId(Integer codBaixa, Long codgrupoLancamento) {
        this.codBaixa = codBaixa;
        this.codGrupoLancamento = codgrupoLancamento;
    }

    public Integer getCodBaixa() {
        return codBaixa;
    }

    public void setCodBaixa(Integer codBaixa) {
        this.codBaixa = codBaixa;
    }

    public Long getCodGrupoLancamento() {
        return codGrupoLancamento;
    }

    public void setCodGrupoLancamento(Long codgrupoLancamento) {
        this.codGrupoLancamento = codgrupoLancamento;
    }
}
