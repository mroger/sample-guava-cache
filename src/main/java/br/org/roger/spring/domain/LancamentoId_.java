package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LancamentoId.class)
public abstract class LancamentoId_ {

	public static volatile SingularAttribute<LancamentoId, Long> grupoLancamentoId;
	public static volatile SingularAttribute<LancamentoId, Integer> tipoItemPagamentoId;

}

