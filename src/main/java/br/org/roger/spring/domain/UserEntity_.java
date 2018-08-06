package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SetAttribute<UserEntity, Address> address;
	public static volatile SetAttribute<UserEntity, Document> documents;
	public static volatile SingularAttribute<UserEntity, String> entityType;
	public static volatile SingularAttribute<UserEntity, NumberSequence> numberSequence;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SetAttribute<UserEntity, Conta> contas;
	public static volatile SingularAttribute<UserEntity, Login> login;
	public static volatile SingularAttribute<UserEntity, Integer> entityStatusId;
	public static volatile SingularAttribute<UserEntity, Long> countryId;

}

