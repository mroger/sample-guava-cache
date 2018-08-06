package br.org.roger.spring.domain;


import javax.persistence.*;
import java.math.BigDecimal;


@SuppressWarnings("serial")
@Entity
@Table(name="OFFER_DETAIL")
@NamedQueries({
}) 
public class OfferDetail  implements java.io.Serializable {

	public static final class Queries {
    }
 
    @Id     
    @Column(name="EREG_OFFER_ID", unique=true, nullable=false, precision=9, scale=0)
 	private Long id;
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EREG_OFFER_ID", unique=true, nullable=false, insertable=false, updatable=false)	
    private Offer offer;
    
    @Column(name="EREG_CURRENT_MAX_BID", precision=15, scale=3)
 	private BigDecimal currentMaxBid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public BigDecimal getCurrentMaxBid() {
        return currentMaxBid;
    }

    public void setCurrentMaxBid(BigDecimal currentMaxBid) {
        this.currentMaxBid = currentMaxBid;
    }
}


