package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 08/05/2017.
 */
public class SumTaxDTO {
    private String typeDesc;
    private BigDecimal totalAmount = new BigDecimal(0L);
    private List<TaxDTO> taxes = new ArrayList<TaxDTO>();

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxDTO> taxes) {
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return "SumTaxDTO{" +
                "typeDesc='" + typeDesc + '\'' +
                ", totalAmount=" + totalAmount +
                ", taxes=" + taxes +
                '}';
    }
}
