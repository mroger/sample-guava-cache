package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(VendaStatus.class)
public abstract class StatusVenda_ {

	public static volatile SingularAttribute<VendaStatus, String> description;
	public static volatile SetAttribute<VendaStatus, Venda>       vendas;
	public static volatile SingularAttribute<VendaStatus, Long>   codVenda;

}

