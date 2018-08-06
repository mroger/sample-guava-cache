package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;

/**
 * Created by chen on 02/08/2016.
 */
public class PurchasePaymentItemDTO {

    private Long paymentId;
    private Integer itemTypeId;
    private BigDecimal value;
    private BigDecimal tax;

    public PurchasePaymentItemDTO() {
    }

    public PurchasePaymentItemDTO(Long paymentId, BigDecimal value, BigDecimal tax, Integer itemTypeId) {
        this.paymentId = paymentId;
        this.value = value;
        this.tax = tax;
        this.itemTypeId = itemTypeId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
}
