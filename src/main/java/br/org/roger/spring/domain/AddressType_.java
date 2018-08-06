package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AddressType.class)
public abstract class AddressType_ {

	public static volatile SingularAttribute<AddressType, String> description;
	public static volatile SingularAttribute<AddressType, Integer> id;

}

