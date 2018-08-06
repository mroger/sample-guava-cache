package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ItemPagamento.class)
public abstract class ItemPagamento_ {

	public static volatile SingularAttribute<ItemPagamento, Long> entryGroup;
	public static volatile SingularAttribute<ItemPagamento, Long> paymentId;
	public static volatile SingularAttribute<ItemPagamento, ItemPagamentoId> id;

}

