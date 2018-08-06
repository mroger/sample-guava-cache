package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LancamentoStatus.class)
public abstract class LancamentoStatus_ {

	public static volatile SingularAttribute<LancamentoStatus, Integer> id;
	public static volatile SingularAttribute<LancamentoStatus, String> desc;

}

