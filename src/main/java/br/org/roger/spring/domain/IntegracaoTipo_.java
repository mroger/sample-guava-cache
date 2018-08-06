package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(IntegracaoTipo.class)
public abstract class IntegracaoTipo_ {

	public static volatile SingularAttribute<IntegracaoTipo, Long> id;
	public static volatile SingularAttribute<IntegracaoTipo, String> desc;

}

