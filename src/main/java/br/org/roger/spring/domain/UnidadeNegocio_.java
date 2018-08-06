package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UnidadeNegocio.class)
public abstract class UnidadeNegocio_ {

	public static volatile SingularAttribute<UnidadeNegocio, String> descUnidadeNegocio;
	public static volatile SingularAttribute<UnidadeNegocio, SegmentoNegocio> segmentoNegocio;
	public static volatile SingularAttribute<UnidadeNegocio, Integer> nroUnidadeNegocio;
	public static volatile SingularAttribute<UnidadeNegocio, Long> id;

}

