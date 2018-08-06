package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BoletoId.class)
public abstract class BoletoId_ {

	public static volatile SingularAttribute<BoletoId, Long> grupoLancamentoId;
	public static volatile SingularAttribute<BoletoId, Integer> quantidadeProrrogacao;

}

