package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 02/08/2016.
 */
public class PaymentDTO {

    private Long id;
    private String identification;
    private String documentNumber;
    private Long payerId;
    private String instruction;
    private Date createdAt;
    private Date expiresAt;
    private Date paidAt;
    private BigDecimal grossValue;
    private Long statusId;
    private String statusDesc;
    private String currency;
    private StoreDTO store;
    private List<EntryGroupDTO> entryGroups;

    public PaymentDTO() {
    }


    public PaymentDTO(Long id, String identification, Long payerId, String instruction, Date createdAt, Date
            expiresAt, Date paidAt, BigDecimal grossValue, Long statusId, String statusDesc, String currency, Long
            storeId, String storeDesc, Long ownerId, Integer countryId, String countryIso, Integer erpSystem) {
        this.id = id;
        this.identification = identification;
        this.payerId = payerId;
        this.instruction = instruction;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.paidAt = paidAt;
        this.grossValue = grossValue;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.currency = currency;
        this.store = new StoreDTO(storeId, storeDesc, ownerId, countryId, erpSystem, countryIso);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
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

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EntryGroupDTO> getEntryGroups() {
        return entryGroups;
    }

    public void setEntryGroups(List<EntryGroupDTO> entryGroups) {
        this.entryGroups = entryGroups;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @deprecated
     */
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }
}
