package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EntryItemValueDTO {

    private Long offerId;
    private BigDecimal value;
    private Integer entryGroupStatusId;
    private Long sellerId;
    private Long destinyUserEntityId;
    private Date scheduledAt;

    public EntryItemValueDTO() {
    }

    public EntryItemValueDTO(Long offerId, BigDecimal value, Integer entryGroupStatusId, Long sellerId, Long destinyUserEntityId, Date scheduledAt) {
        this.offerId = offerId;
        this.value = value;
        this.entryGroupStatusId = entryGroupStatusId;
        this.sellerId = sellerId;
        this.destinyUserEntityId = destinyUserEntityId;
        this.scheduledAt = scheduledAt;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getEntryGroupStatusId() {
        return entryGroupStatusId;
    }

    public void setEntryGroupStatusId(Integer entryGroupStatusId) {
        this.entryGroupStatusId = entryGroupStatusId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getDestinyUserEntityId() {
        return destinyUserEntityId;
    }

    public void setDestinyUserEntityId(Long destinyUserEntityId) {
        this.destinyUserEntityId = destinyUserEntityId;
    }

    public Date getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
}
