package br.org.roger.spring.domain.dto;

public class CostCenterDTO {

    private Long costCenterId;
    private String costCenterDesc;
    private Integer businessUnitNumber;
    private Integer businessSegmentNumber;

    public CostCenterDTO() {
    }

    public CostCenterDTO(Long costCenterId, String costCenterDesc, Integer businessUnitNumber, Integer businessSegmentNumber) {
        this.costCenterId = costCenterId;
        this.costCenterDesc = costCenterDesc;
        this.businessUnitNumber = businessUnitNumber;
        this.businessSegmentNumber = businessSegmentNumber;
    }

    public Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getCostCenterDesc() {
        return costCenterDesc;
    }

    public void setCostCenterDesc(String costCenterDesc) {
        this.costCenterDesc = costCenterDesc;
    }

    public Integer getBusinessUnitNumber() {
        return businessUnitNumber;
    }

    public void setBusinessUnitNumber(Integer businessUnitNumber) {
        this.businessUnitNumber = businessUnitNumber;
    }

    public Integer getBusinessSegmentNumber() {
        return businessSegmentNumber;
    }

    public void setBusinessSegmentNumber(Integer businessSegmentNumber) {
        this.businessSegmentNumber = businessSegmentNumber;
    }
}