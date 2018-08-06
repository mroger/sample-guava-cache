package br.org.roger.spring.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, String> description;
	public static volatile SingularAttribute<Role, Integer> id;
	public static volatile ListAttribute<Role, RoleDocumentType> roleDocumentType;

}

