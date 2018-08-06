package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CancelamentoHistorico.class)
public abstract class CancelamentoHistorico_ {

	public static volatile SingularAttribute<CancelamentoHistorico, Integer> motivoCancelamentoId;
	public static volatile SingularAttribute<CancelamentoHistorico, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<CancelamentoHistorico, Long> id;

}

