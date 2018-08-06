package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PagamentoItem.class)
public abstract class PagamentoItem_ {

	public static volatile SingularAttribute<PagamentoItem, Long> pagamentoId;
	public static volatile SingularAttribute<PagamentoItem, Long> grupoLancamentoId;

}

