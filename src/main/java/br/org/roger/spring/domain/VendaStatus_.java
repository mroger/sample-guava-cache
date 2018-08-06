package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(VendaStatus.class)
public abstract class VendaStatus_ {

	public static volatile SingularAttribute<VendaStatus, Long> id;
	public static volatile SingularAttribute<VendaStatus, String> desc;

}

