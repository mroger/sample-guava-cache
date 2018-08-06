package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProjetoLeilaoStatus.class)
public abstract class ProjetoLeilaoStatus_ {

	public static volatile SingularAttribute<ProjetoLeilaoStatus, Integer> id;
	public static volatile SingularAttribute<ProjetoLeilaoStatus, String> desc;

}

