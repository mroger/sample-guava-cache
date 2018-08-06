package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PreLancamentoTipo.class)
public abstract class PreLancamentoTipo_ {

	public static volatile SingularAttribute<PreLancamentoTipo, String> descricaoTipoPreLancamento;
	public static volatile SetAttribute<PreLancamentoTipo, PreLancamento> preLancamentos;
	public static volatile SingularAttribute<PreLancamentoTipo, Integer> id;

}

