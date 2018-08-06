package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(NotaArrematacao.class)
public abstract class NotaArrematacao_ {

	public static volatile SingularAttribute<NotaArrematacao, Date> dataLiberacao;
	public static volatile SingularAttribute<NotaArrematacao, Date> dataImpresso;
	public static volatile SingularAttribute<NotaArrematacao, GrupoLancamento> grupoLancamento;
	public static volatile SingularAttribute<NotaArrematacao, Long> id;

}

