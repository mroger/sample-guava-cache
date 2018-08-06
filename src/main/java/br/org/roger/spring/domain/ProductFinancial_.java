package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductFinancial.class)
public abstract class ProductFinancial_ {

	public static volatile SingularAttribute<ProductFinancial, Product> product;
	public static volatile SingularAttribute<ProductFinancial, Long> id;
	public static volatile SingularAttribute<ProductFinancial, Integer> codClassFiscal;
	public static volatile SingularAttribute<ProductFinancial, String> descFaturamento;

}

