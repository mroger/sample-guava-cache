package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, String> loginName;
	public static volatile SingularAttribute<Login, String> loginPassword;
	public static volatile SingularAttribute<Login, Long> entityId;
	public static volatile SingularAttribute<Login, UserEntity> entity;

}

