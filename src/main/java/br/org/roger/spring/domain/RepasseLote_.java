package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(RepasseLote.class)
public abstract class RepasseLote_ {

	public static volatile SingularAttribute<RepasseLote, Repasse> repasse;
	public static volatile SingularAttribute<RepasseLote, BigDecimal> valorLote;
	public static volatile SingularAttribute<RepasseLote, RepasseLoteId> id;

}

