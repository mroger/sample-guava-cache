package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RepasseStatus.class)
public abstract class RepasseStatus_ {

	public static volatile SingularAttribute<RepasseStatus, Integer> id;
	public static volatile SingularAttribute<RepasseStatus, String> desc;

}

