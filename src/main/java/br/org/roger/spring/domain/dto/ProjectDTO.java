package br.org.roger.spring.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ailson on 07/11/2016.
 */
public class ProjectDTO {

    private Long id;

    @NotNull(message = "project_desc_required")
    @Length(min = 3, max = 30, message = "project_desc_maxsize_exceeded")
    private String desc;

    @NotNull(message = "portal_id_required")
    private Integer portalId;

    private Long unitId;
    private Long businessGroupId;

    @NotNull(message = "seller_id_required")
    private Long sellerId;
    private String sellerName;
    private Date endDatePrev;
    private Integer statusId;
    private String statusDesc;
    private Date createdAt;
    private Date changedAt;
    private Boolean integrated;
    private Long gestorId;
    private Integer departamentId;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String desc, Integer portalId, Long unitId, Long businessGroupId, Long sellerId, String sellerName, Date endDatePrev, Integer statusId, String statusDesc, Date createdAt, Date changedAt, Boolean integrated, Long gestorId, Integer departamentId) {
        this.id = id;
        this.desc = desc;
        this.unitId = unitId;
        this.portalId = portalId;
        this.businessGroupId = businessGroupId;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.endDatePrev = endDatePrev;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.createdAt = createdAt;
        this.changedAt = changedAt;
        this.integrated = integrated;
        this.gestorId = gestorId;
        this.departamentId = departamentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPortalId() {
        return portalId;
    }

    public void setPortalId(Integer portalId) {
        this.portalId = portalId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getBusinessGroupId() {
        return businessGroupId;
    }

    public void setBusinessGroupId(Long businessGroupId) {
        this.businessGroupId = businessGroupId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Date getEndDatePrev() {
        return endDatePrev;
    }

    public void setEndDatePrev(Date endDatePrev) {
        this.endDatePrev = endDatePrev;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public Boolean getIntegrated() {
        return integrated;
    }

    public void setIntegrated(Boolean integrated) {
        this.integrated = integrated;
    }

    public Long getGestorId() {
        return gestorId;
    }

    public void setGestorId(Long gestorId) {
        this.gestorId = gestorId;
    }

    public Integer getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Integer departamentId) {
        this.departamentId = departamentId;
    }
}
