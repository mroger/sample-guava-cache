package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;

/**
 * Created by chen on 16/09/2015.
 */
public class AuctionSummaryDTO {

    private BigDecimal soldOfferValue = BigDecimal.ZERO;
    private Long soldOfferCount = 0l;

    private BigDecimal paidOfferValue = BigDecimal.ZERO;
    private Long paidOfferCount = 0l;

    private BigDecimal pendingOfferValue = BigDecimal.ZERO;
    private Long pendingOfferCount = 0l;

    private BigDecimal scheduledOfferValue = BigDecimal.ZERO;
    private Long scheduledOfferCount = 0l;

    private BigDecimal notDistributedOfferValue = BigDecimal.ZERO;
    private Long notDistributedOfferCount = 0l;

    private BigDecimal distributedOfferValue = BigDecimal.ZERO;
    private Long distributedOfferCount = 0l;

    private BigDecimal validAdvanceDistributedOfferValue = BigDecimal.ZERO;
    private Long validAdvanceDistributedOfferCount = 0l;

    public BigDecimal getSoldOfferValue() {
        return soldOfferValue;
    }

    public void setSoldOfferValue(BigDecimal soldOfferValue) {
        this.soldOfferValue = soldOfferValue;
    }

    public Long getSoldOfferCount() {
        return soldOfferCount;
    }

    public void setSoldOfferCount(Long soldOfferCount) {
        this.soldOfferCount = soldOfferCount;
    }

    public BigDecimal getPaidOfferValue() {
        return paidOfferValue;
    }

    public void setPaidOfferValue(BigDecimal paidOfferValue) {
        this.paidOfferValue = paidOfferValue;
    }

    public Long getPaidOfferCount() {
        return paidOfferCount;
    }

    public void setPaidOfferCount(Long paidOfferCount) {
        this.paidOfferCount = paidOfferCount;
    }

    public BigDecimal getPendingOfferValue() {
        return pendingOfferValue;
    }

    public void setPendingOfferValue(BigDecimal pendingOfferValue) {
        this.pendingOfferValue = pendingOfferValue;
    }

    public Long getPendingOfferCount() {
        return pendingOfferCount;
    }

    public void setPendingOfferCount(Long pendingOfferCount) {
        this.pendingOfferCount = pendingOfferCount;
    }

    public BigDecimal getScheduledOfferValue() {
        return scheduledOfferValue;
    }

    public void setScheduledOfferValue(BigDecimal scheduledOfferValue) {
        this.scheduledOfferValue = scheduledOfferValue;
    }

    public Long getScheduledOfferCount() {
        return scheduledOfferCount;
    }

    public void setScheduledOfferCount(Long scheduledOfferCount) {
        this.scheduledOfferCount = scheduledOfferCount;
    }

    public BigDecimal getNotDistributedOfferValue() {
        return notDistributedOfferValue;
    }

    public void setNotDistributedOfferValue(BigDecimal notDistributedOfferValue) {
        this.notDistributedOfferValue = notDistributedOfferValue;
    }

    public BigDecimal getDistributedOfferValue() {
        return distributedOfferValue;
    }

    public void setDistributedOfferValue(BigDecimal distributedOfferValue) {
        this.distributedOfferValue = distributedOfferValue;
    }

    public void setNotDistributedOfferCount(Long notDistributedOfferCount) {
        this.notDistributedOfferCount = notDistributedOfferCount;
    }

    public void setDistributedOfferCount(Long distributedOfferCount) {
        this.distributedOfferCount = distributedOfferCount;
    }

    public Long getNotDistributedOfferCount() {
        return notDistributedOfferCount;
    }

    public Long getDistributedOfferCount() {
        return distributedOfferCount;
    }

    public BigDecimal getValidAdvanceDistributedOfferValue() {
        return validAdvanceDistributedOfferValue;
    }

    public void setValidAdvanceDistributedOfferValue(BigDecimal validAdvanceDistributedOfferValue) {
        this.validAdvanceDistributedOfferValue = validAdvanceDistributedOfferValue;
    }

    public Long getValidAdvanceDistributedOfferCount() {
        return validAdvanceDistributedOfferCount;
    }

    public void setValidAdvanceDistributedOfferCount(Long validAdvanceDistributedOfferCount) {
        this.validAdvanceDistributedOfferCount = validAdvanceDistributedOfferCount;
    }
}
