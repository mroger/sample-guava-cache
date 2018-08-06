package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Banco.class)
public abstract class Banco_ {

	public static volatile SingularAttribute<Banco, String> numero;
	public static volatile SingularAttribute<Banco, Integer> statusId;
	public static volatile SingularAttribute<Banco, String> nome;
	public static volatile SingularAttribute<Banco, Long> id;

}

