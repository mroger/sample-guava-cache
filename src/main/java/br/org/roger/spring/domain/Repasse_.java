package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Repasse.class)
public abstract class Repasse_ {

	public static volatile SingularAttribute<Repasse, Long> auctionId;
	public static volatile SingularAttribute<Repasse, Long> sellerId;
	public static volatile SingularAttribute<Repasse, Integer> statusId;
	public static volatile SetAttribute<Repasse, RepasseLote> repasseLote;
	public static volatile SingularAttribute<Repasse, Long> id;
	public static volatile SingularAttribute<Repasse, Long> entidadeOrigem;

}

