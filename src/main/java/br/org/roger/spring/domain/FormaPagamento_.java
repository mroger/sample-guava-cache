package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(FormaPagamento.class)
public abstract class FormaPagamento_ {

	public static volatile SingularAttribute<FormaPagamento, Integer> id;
	public static volatile SingularAttribute<FormaPagamento, String> desc;

}

