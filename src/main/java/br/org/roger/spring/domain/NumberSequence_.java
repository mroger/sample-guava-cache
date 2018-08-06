package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(NumberSequence.class)
public abstract class NumberSequence_ {

	public static volatile SingularAttribute<NumberSequence, Long> sequencia;
	public static volatile SingularAttribute<NumberSequence, Long> id;
	public static volatile SingularAttribute<NumberSequence, UserEntity> entity;

}

