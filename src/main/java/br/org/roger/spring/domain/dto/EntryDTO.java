package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ailson.moreira on 07/04/2017.
 */
public class EntryDTO {
    private Long entryGroupId;
    private Long typeId;
    private String typeDesc;
    private Integer statusId;
    private String statusDesc;
    private BigDecimal value;
    private BigDecimal taxValue;
    private BigDecimal amount;
    private List<TaxDTO> taxes;

    public EntryDTO() {
    }

    public EntryDTO(Long entryGroupId, Long typeId, String typeDesc, Integer statusId, String statusDesc, BigDecimal value, BigDecimal taxValue, BigDecimal amount, List<TaxDTO> taxes) {
        this.entryGroupId = entryGroupId;
        this.typeId = typeId;
        this.typeDesc = typeDesc;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.value = value;
        this.taxValue = taxValue;
        this.amount = amount;
        this.taxes = taxes;
    }

    public Long getEntryGroupId() {
        return entryGroupId;
    }

    public void setEntryGroupId(Long entryGroupId) {
        this.entryGroupId = entryGroupId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxDTO> taxes) {
        this.taxes = taxes;
    }
}
