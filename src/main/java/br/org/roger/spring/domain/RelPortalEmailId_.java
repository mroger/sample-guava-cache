package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RelPortalEmailId.class)
public abstract class RelPortalEmailId_ {

	public static volatile SingularAttribute<RelPortalEmailId, Short> portalId;
	public static volatile SingularAttribute<RelPortalEmailId, Integer> emailId;
	public static volatile SingularAttribute<RelPortalEmailId, Short> portalContactId;

}

