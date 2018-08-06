package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RepasseFormaPag.class)
public abstract class RepasseFormaPag_ {

	public static volatile SingularAttribute<RepasseFormaPag, String> sigla;
	public static volatile SingularAttribute<RepasseFormaPag, Integer> id;
	public static volatile SingularAttribute<RepasseFormaPag, String> desc;

}

