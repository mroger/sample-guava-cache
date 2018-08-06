package br.org.roger.spring.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by walter on 14/11/16.
 */

public class BillingInformationDTO {

    private Long id;

    @NotNull(message = "sale_order_id_required")
    private Long saleOrderId;

    private Integer extendTimes;

    @Length(min = 3, max = 50, message = "identification_maxsize_exceeded")
    private String identification;

    private String documentNumber;

    @NotNull(message = "createdAt_required")
    private Date createdAt;

    private Date updatedAt;

    @NotNull(message = "expiresAt_required")
    private Date expiresAt;

    @NotNull(message = "grossValue_required")
    private BigDecimal grossValue;

    private Long statusId;

    private String statusKey;

    private List<TaxDTO> taxes;

    public BillingInformationDTO() {
    }

    public BillingInformationDTO(Long id, Long saleOrderId, String identification, Date createdAt, Date expiresAt, BigDecimal grossValue, Long statusId) {
        this.id = id;
        this.saleOrderId = saleOrderId;
        this.identification = identification;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.grossValue = grossValue;
        this.statusId = statusId;
    }

    public BillingInformationDTO(Long id, Long saleOrderId, String identification, Date createdAt, Date expiresAt, BigDecimal grossValue, Long statusId, String statusKey) {
        this.id = id;
        this.saleOrderId = saleOrderId;
        this.identification = identification;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.grossValue = grossValue;
        this.statusId = statusId;
        this.statusKey = statusKey;
    }

    public BillingInformationDTO(Long saleOrderId, Integer extendTimes, String identification, String documentNumber, Date createdAt, Date updatedAt, Date expiresAt, BigDecimal grossValue) {
        this.saleOrderId = saleOrderId;
        this.extendTimes = extendTimes;
        this.identification = identification;
        this.documentNumber = documentNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expiresAt = expiresAt;
        this.grossValue = grossValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Long saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Integer getExtendTimes() {
        return extendTimes;
    }

    public void setExtendTimes(Integer extendTimes) {
        this.extendTimes = extendTimes;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey;
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxDTO> taxes) {
        this.taxes = taxes;
    }
}
