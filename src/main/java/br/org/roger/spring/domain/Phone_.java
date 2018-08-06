package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Phone.class)
public abstract class Phone_ {

	public static volatile SingularAttribute<Phone, String> phoneNumber;
	public static volatile SingularAttribute<Phone, String> phoneDDD;
	public static volatile SingularAttribute<Phone, String> phoneDDI;
	public static volatile SingularAttribute<Phone, Long> entityId;
	public static volatile SingularAttribute<Phone, Long> id;
	public static volatile SingularAttribute<Phone, Integer> type;
	public static volatile SingularAttribute<Phone, UserEntity> entity;
	public static volatile SetAttribute<Phone, RelPortalPhone> relPortalPhones;

}

