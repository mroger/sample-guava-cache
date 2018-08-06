package br.org.roger.spring.domain;

import javax.persistence.*;

/**
 * FlUnidadeNegocio generated by hbm2java
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "FL_UNIDADE_NEGOCIO")
@NamedQueries({})
public class UnidadeNegocio implements java.io.Serializable {

	public static final class Queries {
	}

	@Id
	@Column(name = "COD_UNIDADE_NEGOCIO", unique = true, nullable = false, precision = 9, scale = 0)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SEGMENTO_NEGOCIO")
	private SegmentoNegocio segmentoNegocio;

	@Column(name = "NRO_UNIDADE_NEGOCIO", precision = 3, scale = 0)
	private Integer nroUnidadeNegocio;

	@Column(name = "DESC_UNIDADE_NEGOCIO", length = 50)
	private String descUnidadeNegocio;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SegmentoNegocio getSegmentoNegocio() {
        return segmentoNegocio;
    }

    public void setSegmentoNegocio(SegmentoNegocio segmentoNegocio) {
        this.segmentoNegocio = segmentoNegocio;
    }

    public Integer getNroUnidadeNegocio() {
        return nroUnidadeNegocio;
    }

    public void setNroUnidadeNegocio(Integer nroUnidadeNegocio) {
        this.nroUnidadeNegocio = nroUnidadeNegocio;
    }

    public String getDescUnidadeNegocio() {
        return descUnidadeNegocio;
    }

    public void setDescUnidadeNegocio(String descUnidadeNegocio) {
        this.descUnidadeNegocio = descUnidadeNegocio;
    }
}