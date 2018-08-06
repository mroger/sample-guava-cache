package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AberturaComStatus.class)
public abstract class AberturaComStatus_ {

	public static volatile SingularAttribute<AberturaComStatus, Long> id;
	public static volatile SingularAttribute<AberturaComStatus, String> status;

}

