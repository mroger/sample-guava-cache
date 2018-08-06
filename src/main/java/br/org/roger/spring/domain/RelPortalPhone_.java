package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RelPortalPhone.class)
public abstract class RelPortalPhone_ {

	public static volatile SingularAttribute<RelPortalPhone, Phone> phone;
	public static volatile SingularAttribute<RelPortalPhone, RelPortalPhoneId> id;
	public static volatile SingularAttribute<RelPortalPhone, Integer> portalContactId;
	public static volatile SingularAttribute<RelPortalPhone, Portal> portal;

}

