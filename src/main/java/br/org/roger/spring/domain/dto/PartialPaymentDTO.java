package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by eduardo on 25/04/2017.
 */
public class PartialPaymentDTO {

    private Long entryGroupId;
    private Integer sequence;
    private BigDecimal fullAmount;
    private BigDecimal payedAmount;
    private Boolean active;
    private Date payedAt;
    private Date canceledAt;

    public Long getEntryGroupId() {
        return entryGroupId;
    }

    public void setEntryGroupId(Long entryGroupId) {
        this.entryGroupId = entryGroupId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(BigDecimal fullAmount) {
        this.fullAmount = fullAmount;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Date getPayedAt() {
        return payedAt;
    }

    public void setPayedAt(Date payedAt) {
        this.payedAt = payedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }
}
