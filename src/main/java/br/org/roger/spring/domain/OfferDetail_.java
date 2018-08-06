package br.org.roger.spring.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(OfferDetail.class)
public abstract class OfferDetail_ {

	public static volatile SingularAttribute<OfferDetail, Offer> offer;
	public static volatile SingularAttribute<OfferDetail, Long> id;
	public static volatile SingularAttribute<OfferDetail, BigDecimal> currentMaxBid;

}

