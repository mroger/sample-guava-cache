package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Deposito.class)
public abstract class Deposito_ {

	public static volatile SingularAttribute<Deposito, BigDecimal> valorBruto;
	public static volatile SingularAttribute<Deposito, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<Deposito, Long> id;
	public static volatile SingularAttribute<Deposito, String> identificador;

}

