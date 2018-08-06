package br.org.roger.spring.domain;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
@Entity
@Table(name = "OFFER")
@NamedQueries({
})
public class Offer implements java.io.Serializable {

	public static final class Queries {
	}
	
	@Id
	@Column(name = "EREG_OFFER_ID", unique = true, nullable = false, precision = 9, scale = 0)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_OFFER_ID")
	private GroupOffer groupOffer;
	
	@Column(name = "GROUP_OFFER_ID", insertable=false, updatable=false)
	private Long groupOfferId;

	@Column(name = "EREG_QUANTITY_TO_SALE", precision = 15, scale = 3)
	private BigDecimal quantityToSale;

    @Column(name = "EREG_QUANTITY_IN_LOT", precision = 15, scale = 3)
    private BigDecimal quantityInLot;

    @Formula("ereg_quantity_to_sale * ereg_quantity_in_lot")
    private BigDecimal quantity;

	@Column(name = "EREG_LOT_NUMBER", precision = 9, scale = 0)
	private Integer lotNumber;
	
	@Formula("DECODE(SUB_LOTE, '', TO_CHAR(EREG_LOT_NUMBER), TO_CHAR(EREG_LOT_NUMBER)||'.'||SUB_LOTE)")
	private String lotNumberDesc;

	@Column(name = "SUB_LOTE", length = 5)
	private String subLote;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "offer")
	private OfferDetail offerDetail;
	
	@Column(name = "BID_ID_EXTRA_TIME", precision = 9, scale = 0)
	private Long bidIdExtraTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NUMBER_AUCTION", insertable=false, updatable=false)
    private Auction auction;

    @Column(name = "NUMBER_AUCTION", precision = 9)
    private Long auctionId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "offer")
    private Set<PreLancamento> preLancamentos = new HashSet<PreLancamento>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EREG_PRODUCT_ID", nullable = false, insertable = false, updatable = false)
    private Product product;

    @Column(name = "EREG_PRODUCT_ID", nullable = false, precision = 9, scale = 0)
    private Long productId;

    @Column(name = "EREG_OFFER_TYPE_ID", nullable = false, precision = 9, scale = 0)
    private Long typeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupOffer getGroupOffer() {
        return groupOffer;
    }

    public void setGroupOffer(GroupOffer groupOffer) {
        this.groupOffer = groupOffer;
    }

    public Long getGroupOfferId() {
        return groupOfferId;
    }

    public void setGroupOfferId(Long groupOfferId) {
        this.groupOfferId = groupOfferId;
    }

    public BigDecimal getQuantityToSale() {
        return quantityToSale;
    }

    public void setQuantityToSale(BigDecimal quantityToSale) {
        this.quantityToSale = quantityToSale;
    }

    public BigDecimal getQuantityInLot() {
        return quantityInLot;
    }

    public void setQuantityInLot(BigDecimal quantityInLot) {
        this.quantityInLot = quantityInLot;
    }

    public Integer getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(Integer lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotNumberDesc() {
        return lotNumberDesc;
    }

    public void setLotNumberDesc(String lotNumberDesc) {
        this.lotNumberDesc = lotNumberDesc;
    }

    public String getSubLote() {
        return subLote;
    }

    public void setSubLote(String subLote) {
        this.subLote = subLote;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public OfferDetail getOfferDetail() {
        return offerDetail;
    }

    public void setOfferDetail(OfferDetail offerDetail) {
        this.offerDetail = offerDetail;
    }

    public Long getBidIdExtraTime() {
        return bidIdExtraTime;
    }

    public void setBidIdExtraTime(Long bidIdExtraTime) {
        this.bidIdExtraTime = bidIdExtraTime;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Set<PreLancamento> getPreLancamentos() {
        return preLancamentos;
    }

    public void setPreLancamentos(Set<PreLancamento> preLancamentos) {
        this.preLancamentos = preLancamentos;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Long getTypeId() { return typeId; }

    public void setTypeId(Long typeId) { this.typeId = typeId; }
}
