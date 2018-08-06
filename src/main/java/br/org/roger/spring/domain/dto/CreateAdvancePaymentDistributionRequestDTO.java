package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CreateAdvancePaymentDistributionRequestDTO {

    private Long auctionId;
    private Long sellerId;
    private Long originPaymentAccountId;
    private Long destinyUserEntityId;
    private Long destinyAccountId;
    private Integer paymentMethodId;
    private BigDecimal advanceValue;
    private Date scheduledAt;
    private String comment;

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getOriginPaymentAccountId() {
        return originPaymentAccountId;
    }

    public void setOriginPaymentAccountId(Long originPaymentAccountId) {
        this.originPaymentAccountId = originPaymentAccountId;
    }

    public Long getDestinyAccountId() {
        return destinyAccountId;
    }

    public void setDestinyAccountId(Long destinyAccountId) {
        this.destinyAccountId = destinyAccountId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getAdvanceValue() {
        return advanceValue;
    }

    public void setAdvanceValue(BigDecimal advanceValue) {
        this.advanceValue = advanceValue;
    }

    public Date getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDestinyUserEntityId() {
        return destinyUserEntityId;
    }

    public void setDestinyUserEntityId(Long destinyUserEntityId) {
        this.destinyUserEntityId = destinyUserEntityId;
    }
}
