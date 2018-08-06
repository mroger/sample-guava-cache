package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(LogSincronizacao.class)
public abstract class LogSincronizacao_ {

	public static volatile SingularAttribute<LogSincronizacao, Date> logDate;
	public static volatile SingularAttribute<LogSincronizacao, Date> syncDate;
	public static volatile SingularAttribute<LogSincronizacao, Integer> operationId;
	public static volatile SingularAttribute<LogSincronizacao, Boolean> active;
	public static volatile SingularAttribute<LogSincronizacao, Long> id;
	public static volatile SingularAttribute<LogSincronizacao, Integer> referenceCode;

}

