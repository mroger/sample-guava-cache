package br.org.roger.spring.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GroupOffer.class)
public abstract class GroupOffer_ {

	public static volatile SingularAttribute<GroupOffer, Long> auctionId;
	public static volatile SetAttribute<GroupOffer, Offer> offers;
	public static volatile SingularAttribute<GroupOffer, ProjetoLeilao> projetoLeilao;
	public static volatile SingularAttribute<GroupOffer, Long> id;
	public static volatile SingularAttribute<GroupOffer, Auction> auction;
	public static volatile SingularAttribute<GroupOffer, UserEntity> userEntitySeller;

}

