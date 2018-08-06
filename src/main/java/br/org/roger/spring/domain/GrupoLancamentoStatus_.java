package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GrupoLancamentoStatus.class)
public abstract class GrupoLancamentoStatus_ {

	public static volatile SingularAttribute<GrupoLancamentoStatus, Integer> id;
	public static volatile SingularAttribute<GrupoLancamentoStatus, String> desc;

}

