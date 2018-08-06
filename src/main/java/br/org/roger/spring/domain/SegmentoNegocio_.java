package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SegmentoNegocio.class)
public abstract class SegmentoNegocio_ {

	public static volatile SingularAttribute<SegmentoNegocio, String> descSegmentoNegocio;
	public static volatile SetAttribute<SegmentoNegocio, UnidadeNegocio> unidadeNegocios;
	public static volatile SingularAttribute<SegmentoNegocio, Long> id;
	public static volatile SingularAttribute<SegmentoNegocio, Integer> nroSegmentoNegocio;

}

