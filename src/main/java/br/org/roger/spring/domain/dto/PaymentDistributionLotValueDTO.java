package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;

public class PaymentDistributionLotValueDTO {

    private Long offerId;
    private BigDecimal value;
    private Integer paymentDistributionStatusId;

    public PaymentDistributionLotValueDTO() {
    }

    public PaymentDistributionLotValueDTO(Long offerId, BigDecimal value, Integer paymentDistributionStatusId) {
        this.offerId = offerId;
        this.value = value;
        this.paymentDistributionStatusId = paymentDistributionStatusId;
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

    public Integer getPaymentDistributionStatusId() {
        return paymentDistributionStatusId;
    }

    public void setPaymentDistributionStatusId(Integer paymentDistributionStatusId) {
        this.paymentDistributionStatusId = paymentDistributionStatusId;
    }
}