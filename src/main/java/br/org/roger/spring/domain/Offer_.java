package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Offer.class)
public abstract class Offer_ {

	public static volatile SingularAttribute<Offer, Product> product;
	public static volatile SingularAttribute<Offer, Long> groupOfferId;
	public static volatile SingularAttribute<Offer, BigDecimal> quantity;
	public static volatile SingularAttribute<Offer, Long> productId;
	public static volatile SingularAttribute<Offer, BigDecimal> quantityToSale;
	public static volatile SingularAttribute<Offer, String> subLote;
	public static volatile SingularAttribute<Offer, Integer> lotNumber;
	public static volatile SingularAttribute<Offer, Long> bidIdExtraTime;
	public static volatile SingularAttribute<Offer, Auction> auction;
	public static volatile SingularAttribute<Offer, Long> auctionId;
	public static volatile SingularAttribute<Offer, OfferDetail> offerDetail;
	public static volatile SingularAttribute<Offer, String> lotNumberDesc;
	public static volatile SingularAttribute<Offer, GroupOffer> groupOffer;
	public static volatile SetAttribute<Offer, PreLancamento> preLancamentos;
	public static volatile SingularAttribute<Offer, Long> id;
	public static volatile SingularAttribute<Offer, BigDecimal> quantityInLot;

}

