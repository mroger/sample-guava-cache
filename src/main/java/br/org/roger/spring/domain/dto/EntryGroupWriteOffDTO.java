package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

/* Created by ailson on 08/02/17. */
public class EntryGroupWriteOffDTO {
    private Long entryGroupId;
    private Long writeDownId;
    private BigDecimal originalValue;
    private BigDecimal writeDownValue;
    private Date writeDownDate;
    private Date cancelWriteDownDate;
    private Boolean active;

    public EntryGroupWriteOffDTO() {
    }

    public Long getEntryGroupId() {
        return entryGroupId;
    }

    public void setEntryGroupId(Long entryGroupId) {
        this.entryGroupId = entryGroupId;
    }

    public Long getWriteDownId() {
        return writeDownId;
    }

    public void setWriteDownId(Long writeDownId) {
        this.writeDownId = writeDownId;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public BigDecimal getWriteDownValue() {
        return writeDownValue;
    }

    public void setWriteDownValue(BigDecimal writeDownValue) {
        this.writeDownValue = writeDownValue;
    }

    public Date getWriteDownDate() {
        return writeDownDate;
    }

    public void setWriteDownDate(Date writeDownDate) {
        this.writeDownDate = writeDownDate;
    }

    public Date getCancelWriteDownDate() {
        return cancelWriteDownDate;
    }

    public void setCancelWriteDownDate(Date cancelWriteDownDate) {
        this.cancelWriteDownDate = cancelWriteDownDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
