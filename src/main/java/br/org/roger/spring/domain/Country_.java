package br.org.roger.spring.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Country.class)
public abstract class Country_ {

	public static volatile SingularAttribute<Country, Integer> id;
	public static volatile ListAttribute<Country, RoleDocumentType> roleDocumentType;
	public static volatile SingularAttribute<Country, String> sigla;
	public static volatile SingularAttribute<Country, String> name;
	public static volatile SingularAttribute<Country, Integer> ddi;

}

