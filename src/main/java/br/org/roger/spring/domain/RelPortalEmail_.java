package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RelPortalEmail.class)
public abstract class RelPortalEmail_ {

	public static volatile SingularAttribute<RelPortalEmail, RelPortalEmailId> id;
	public static volatile SingularAttribute<RelPortalEmail, Integer> portalContactId;
	public static volatile SingularAttribute<RelPortalEmail, Portal> portal;
	public static volatile SingularAttribute<RelPortalEmail, Email> email;

}

