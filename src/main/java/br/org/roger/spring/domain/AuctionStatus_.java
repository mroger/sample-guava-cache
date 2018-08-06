package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AuctionStatus.class)
public abstract class AuctionStatus_ {

	public static volatile SingularAttribute<AuctionStatus, Long> id;

}

