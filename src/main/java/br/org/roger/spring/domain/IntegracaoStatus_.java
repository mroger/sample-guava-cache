package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(IntegracaoStatus.class)
public abstract class IntegracaoStatus_ {

	public static volatile SingularAttribute<IntegracaoStatus, Long> id;
	public static volatile SingularAttribute<IntegracaoStatus, String> desc;

}

