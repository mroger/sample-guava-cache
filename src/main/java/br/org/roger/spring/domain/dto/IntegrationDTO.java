package br.org.roger.spring.domain.dto;

/**
 * Created by ailson.moreira on 12/04/2017.
 */
public class IntegrationDTO {
    private Long id;
    private Long entryGroupId;
    private Long typeId;
    private String typeDesc;
    private Long statusId;
    private String statusDesc;

    public IntegrationDTO() {
    }

    public IntegrationDTO(Long id, Long entryGroupId, Long typeId, String typeDesc, Long statusId, String statusDesc) {
        this.id = id;
        this.entryGroupId = entryGroupId;
        this.typeId = typeId;
        this.typeDesc = typeDesc;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
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
}
