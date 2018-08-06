package br.org.roger.spring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
@Entity
@Table(name = "GROUP_OFFER")
@NamedQueries({
})
public class GroupOffer implements java.io.Serializable {

	public static final class Queries {
	}

	/* GERADO
	 */
	public static final int OPENED = 1;

	/* RESTRITO
	 */
	public static final int RESTRICT = 2;

	/* COMPARTILHADO-GERADO
	 */
	public static final int SHARE_OPENED = 3;

	/* COMPARTILHADO-RESTRITO
	 */
	public static final int SHARE_RESTRICT = 4;

	@Id
	@Column(name = "GROUP_OFFER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "AUCTION_ID", precision = 9, scale = 0)
	private Long auctionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUCTION_ID", insertable = false, updatable = false)
	private Auction auction;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupOffer")
	private Set<Offer> offers = new HashSet<Offer>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PROJETO_LEILAO", insertable = false, updatable = false)
    private ProjetoLeilao projetoLeilao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_SELLER_ID", nullable = false, insertable = false, updatable = false)
    private UserEntity userEntitySeller;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

    public ProjetoLeilao getProjetoLeilao() {
        return projetoLeilao;
    }

    public void setProjetoLeilao(ProjetoLeilao projetoLeilao) {
        this.projetoLeilao = projetoLeilao;
    }

    public UserEntity getUserEntitySeller() {
        return userEntitySeller;
    }

    public void setUserEntitySeller(UserEntity userEntitySeller) {
        this.userEntitySeller = userEntitySeller;
    }
}
