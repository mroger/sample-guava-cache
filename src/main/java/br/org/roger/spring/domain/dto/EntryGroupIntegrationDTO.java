package br.org.roger.spring.domain.dto;

/* Created by walter on 14/11/16. */

public class EntryGroupIntegrationDTO {
    private Long id;
    private Long statusId;
    private String statusDesc;
    private Long typeId;
    private String typeDesc;
    private Long integrationCode;

    public EntryGroupIntegrationDTO() {
    }

    public EntryGroupIntegrationDTO(Long id, Long statusId, String statusDesc, Long typeId, String typeDesc, Long integrationCode) {
        this.id = id;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.typeId = typeId;
        this.typeDesc = typeDesc;
        this.integrationCode = integrationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIntegrationCode() {
        return integrationCode;
    }

    public void setIntegrationCode(Long integrationCode) {
        this.integrationCode = integrationCode;
    }
}
