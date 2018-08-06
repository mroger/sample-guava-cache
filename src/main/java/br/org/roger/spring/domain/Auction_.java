package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Auction.class)
public abstract class Auction_ {

	public static volatile SetAttribute<Auction, Offer> offers;
	public static volatile SingularAttribute<Auction, Integer> statusId;
	public static volatile SingularAttribute<Auction, Date> auctionEndDate;
	public static volatile SingularAttribute<Auction, Integer> auctionModalityId;
	public static volatile SingularAttribute<Auction, Integer> portalId;
	public static volatile SingularAttribute<Auction, String> auctionDesc;
	public static volatile SingularAttribute<Auction, Gestor> gestor;
	public static volatile SingularAttribute<Auction, Long> id;
	public static volatile SingularAttribute<Auction, Portal> portal;
	public static volatile SingularAttribute<Auction, String> localeId;
	public static volatile SingularAttribute<Auction, Locale> locale;

}

