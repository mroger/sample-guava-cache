package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RepasseLoteId.class)
public abstract class RepasseLoteId_ {

	public static volatile SingularAttribute<RepasseLoteId, Long> grupoLancamentoId;
	public static volatile SingularAttribute<RepasseLoteId, Long> repasseId;
	public static volatile SingularAttribute<RepasseLoteId, Long> offerId;

}

