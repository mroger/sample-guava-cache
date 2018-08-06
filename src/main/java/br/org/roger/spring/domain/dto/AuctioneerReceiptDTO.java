package br.org.roger.spring.domain.dto;

import java.util.Date;

/**
 * Created by chen on 08/08/2016.
 */
public class AuctioneerReceiptDTO {

    private Long id;
    private Long purchaseId;
    private Date buyerCopyReleasedAt;
    private Date buyerCopyPrintedAt;
    private String invoiceURL;
    private Long buyerId;

    public AuctioneerReceiptDTO() {
    }

    public AuctioneerReceiptDTO(Long id, Long purchaseId, Date buyerCopyReleasedAt, Date buyerCopyPrintedAt, Long buyerId) {
        this.id = id;
        this.purchaseId = purchaseId;
        this.buyerCopyReleasedAt = buyerCopyReleasedAt;
        this.buyerCopyPrintedAt = buyerCopyPrintedAt;
        this.buyerId = buyerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getBuyerCopyReleasedAt() {
        return buyerCopyReleasedAt;
    }

    public void setBuyerCopyReleasedAt(Date buyerCopyReleasedAt) {
        this.buyerCopyReleasedAt = buyerCopyReleasedAt;
    }

    public Date getBuyerCopyPrintedAt() {
        return buyerCopyPrintedAt;
    }

    public void setBuyerCopyPrintedAt(Date buyerCopyPrintedAt) {
        this.buyerCopyPrintedAt = buyerCopyPrintedAt;
    }

    public String getInvoiceURL() {
        return invoiceURL;
    }

    public void setInvoiceURL(String invoiceURL) {
        this.invoiceURL = invoiceURL;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
