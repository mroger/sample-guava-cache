package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RelPortalPhoneId.class)
public abstract class RelPortalPhoneId_ {

	public static volatile SingularAttribute<RelPortalPhoneId, Integer> portalId;
	public static volatile SingularAttribute<RelPortalPhoneId, Integer> phoneId;
	public static volatile SingularAttribute<RelPortalPhoneId, Short> portalContactId;

}

