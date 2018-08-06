package br.org.roger.spring.domain.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by chen on 01/08/2016.
 */
public class PurchaseDTO {

    private Long id;
    private Long buyerId;
    private Integer statusId;
    // status calculado
    private Integer status;
    private Date generatedAt;

    private Integer countryId;
    private Integer portalId;
    private Long auctionId;
    private String auctionDesc;
    private Date auctionEndDate;

    private String localeId;
    private String currencyId;

    private Long offerId;
    private String offerLotNumber;
    private String productDesc;

    private List<PurchasePaymentDTO> payments;

    private Boolean auctioneerReceiptEnabled;

    private AuctioneerReceiptDTO auctioneerReceipt;


    public PurchaseDTO() {
    }

    public PurchaseDTO(
            Long id, Long buyerId, Integer statusId, Date generatedAt, Integer countryId, Integer portalId, Long auctionId,
            String auctionDesc, Date auctionEndDate, Long offerId, String offerLotNumber, String productDesc, String localeId) {

        this.id = id;
        this.buyerId = buyerId;
        this.statusId = statusId;
        this.generatedAt = generatedAt;
        this.countryId = countryId;
        this.portalId = portalId;
        this.auctionId = auctionId;
        this.auctionDesc = auctionDesc;
        this.auctionEndDate = auctionEndDate;
        this.offerId = offerId;
        this.offerLotNumber = offerLotNumber;
        this.productDesc = productDesc;
        this.localeId = localeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Date getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Date generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Integer getPortalId() {
        return portalId;
    }

    public void setPortalId(Integer portalId) {
        this.portalId = portalId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionDesc() {
        return auctionDesc;
    }

    public void setAuctionDesc(String auctionDesc) {
        this.auctionDesc = auctionDesc;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getOfferLotNumber() {
        return offerLotNumber;
    }

    public void setOfferLotNumber(String offerLotNumber) {
        this.offerLotNumber = offerLotNumber;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public List<PurchasePaymentDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<PurchasePaymentDTO> payments) {
        this.payments = payments;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Boolean getAuctioneerReceiptEnabled() {
        return auctioneerReceiptEnabled;
    }

    public void setAuctioneerReceiptEnabled(Boolean auctioneerReceiptEnabled) {
        this.auctioneerReceiptEnabled = auctioneerReceiptEnabled;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public AuctioneerReceiptDTO getAuctioneerReceipt() {
        return auctioneerReceipt;
    }

    public void setAuctioneerReceipt(AuctioneerReceiptDTO auctioneerReceipt) {
        this.auctioneerReceipt = auctioneerReceipt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getLocaleId() {
        return localeId;
    }

    public void setLocaleId(String localeId) {
        this.localeId = localeId;
    }
}
