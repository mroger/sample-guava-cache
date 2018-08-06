package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, UserEntity> userEntity;
	public static volatile SingularAttribute<Conta, Long> bancoId;
	public static volatile SingularAttribute<Conta, String> contaDigito;
	public static volatile SingularAttribute<Conta, String> agenciaDigito;
	public static volatile SingularAttribute<Conta, Long> userEntityId;
	public static volatile SingularAttribute<Conta, String> conta;
	public static volatile SingularAttribute<Conta, Banco> banco;
	public static volatile SingularAttribute<Conta, Long> id;
	public static volatile SingularAttribute<Conta, String> agencia;

}

