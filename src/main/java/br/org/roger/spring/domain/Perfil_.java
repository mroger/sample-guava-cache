package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Perfil.class)
public abstract class Perfil_ {

	public static volatile SingularAttribute<Perfil, Date> createdAt;
	public static volatile SingularAttribute<Perfil, Integer> portalId;
	public static volatile SingularAttribute<Perfil, String> timezoneId;
	public static volatile SingularAttribute<Perfil, Long> entityId;
	public static volatile SingularAttribute<Perfil, Long> id;
	public static volatile SingularAttribute<Perfil, String> locale;
	public static volatile SingularAttribute<Perfil, String> currencyCode;
	public static volatile SingularAttribute<Perfil, UserEntity> entity;

}

