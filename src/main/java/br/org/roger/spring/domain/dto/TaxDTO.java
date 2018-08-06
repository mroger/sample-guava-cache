package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;

/**
 * Created by ailson.moreira on 22/12/16.
 */
public class TaxDTO {

    private Long id;
    private Long entryGroupId;
    private Long typeId;
    private String typeDesc;
    private String taxDesc;
    private BigDecimal taxValue;

    public TaxDTO() {
    }

    public TaxDTO(Long id, Long entryGroupId, Long typeId, String typeDesc, String taxDesc, BigDecimal taxValue) {
        this.id = id;
        this.entryGroupId = entryGroupId;
        this.typeId = typeId;
        this.typeDesc = typeDesc;
        this.taxDesc = taxDesc;
        this.taxValue = taxValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTaxDesc() {
        return taxDesc;
    }

    public void setTaxDesc(String taxDesc) {
        this.taxDesc = taxDesc;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    @Override
    public String toString() {
        return "TaxDTO{" +
                "id=" + id +
                ", entryGroupId=" + entryGroupId +
                ", typeId=" + typeId +
                ", typeDesc='" + typeDesc + '\'' +
                ", taxDesc='" + taxDesc + '\'' +
                ", taxValue=" + taxValue +
                '}';
    }
}
