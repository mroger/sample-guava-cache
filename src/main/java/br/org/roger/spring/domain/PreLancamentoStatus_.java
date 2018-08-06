package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PreLancamentoStatus.class)
public abstract class PreLancamentoStatus_ {

	public static volatile SingularAttribute<PreLancamentoStatus, String> descricaoStatusPreLanc;
	public static volatile SetAttribute<PreLancamentoStatus, PreLancamento> preLancamentos;
	public static volatile SingularAttribute<PreLancamentoStatus, Integer> id;

}

