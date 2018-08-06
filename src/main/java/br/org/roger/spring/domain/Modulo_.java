package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Modulo.class)
public abstract class Modulo_ {

	public static volatile SingularAttribute<Modulo, Integer> id;
	public static volatile SingularAttribute<Modulo, String> modulo;

}

