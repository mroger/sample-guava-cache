package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * FlPreLancamentoStatus generated by hbm2java
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_PRE_LANCAMENTO_STATUS")
@NamedQueries({})
public class PreLancamentoStatus implements java.io.Serializable {

	public static final class Queries {
	}

    public static final int ABERTO = 1;
    public static final int GERADO = 2;
    public static final int RECUSADO = 3;
    public static final int ENCERRADO_SEM_LANCE = 4;
    public static final int CANCELADO = 5;

	@Id
	@Column(name = "COD_STATUS_PRE_LANCAMENTO", unique = true, nullable = false, precision = 2, scale = 0)
	private Integer id;

	@Column(name = "DESCRICAO_STATUS_PRE_LANC", length = 30)
	private String descricaoStatusPreLanc;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "preLancamentoStatus")
	private Set<PreLancamento> preLancamentos = new HashSet<PreLancamento>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricaoStatusPreLanc() {
        return descricaoStatusPreLanc;
    }

    public void setDescricaoStatusPreLanc(String descricaoStatusPreLanc) {
        this.descricaoStatusPreLanc = descricaoStatusPreLanc;
    }

    public Set<PreLancamento> getPreLancamentos() {
        return preLancamentos;
    }

    public void setPreLancamentos(Set<PreLancamento> preLancamentos) {
        this.preLancamentos = preLancamentos;
    }
}