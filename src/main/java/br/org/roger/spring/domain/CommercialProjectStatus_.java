package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CommercialProjectStatus.class)
public abstract class CommercialProjectStatus_ {

	public static volatile SingularAttribute<CommercialProjectStatus, String> description;
	public static volatile SingularAttribute<CommercialProjectStatus, Integer> id;

}

