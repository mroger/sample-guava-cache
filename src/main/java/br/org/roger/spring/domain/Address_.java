package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, UserEntity> userEntity;
	public static volatile SingularAttribute<Address, String> streetType;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> stateDesc;
	public static volatile SingularAttribute<Address, AddressType> addressType;
	public static volatile SingularAttribute<Address, Long> entityId;
	public static volatile SingularAttribute<Address, Integer> type;
	public static volatile SingularAttribute<Address, Integer> countryId;
	public static volatile SingularAttribute<Address, String> zipcode;
	public static volatile SingularAttribute<Address, String> number;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> district;
	public static volatile SingularAttribute<Address, String> stateCode;
	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, String> complement;
	public static volatile SingularAttribute<Address, String> status;

}

