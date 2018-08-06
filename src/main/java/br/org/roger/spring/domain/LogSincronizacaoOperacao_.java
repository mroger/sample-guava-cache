package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(LogSincronizacaoOperacao.class)
public abstract class LogSincronizacaoOperacao_ {

	public static volatile SingularAttribute<LogSincronizacaoOperacao, Long> id;
	public static volatile SingularAttribute<LogSincronizacaoOperacao, String> operationDesc;

}

