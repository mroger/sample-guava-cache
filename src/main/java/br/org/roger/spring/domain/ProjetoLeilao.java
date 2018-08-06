package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "FL_PROJETO_LEILAO")
@NamedQueries({})
public class ProjetoLeilao implements Serializable {

    @Id
    @GeneratedValue(generator = "triggerGenerator")
    @GenericGenerator(name = "triggerGenerator", strategy = "net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "COD_PROJETO_LEILAO")
    private Long id;

    @Column(name = "DESCRICAO_PROJETO_LEILAO", nullable = false, length = 30)
    private String desc;

    @Column(name = "COD_PORTAL", length = 4)
    private Integer portalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_UNIDADE_NEGOCIO", insertable = false, updatable = false)
    private UnidadeNegocio unidadeNegocio;

    @Column(name = "COD_UNIDADE_NEGOCIO", length = 9)
    private Long unitId;

    @Column(name = "COD_GRUPO_EMPRESARIAL", length = 9)
    private Long businessGroupId;

    @Column(name = "COD_COMITENTE", length = 9)
    private Long sellerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_COMITENTE", insertable = false, updatable = false)
    private UserEntity seller;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "DATA_ENCERRAMENTO_PREV", columnDefinition = "date", length = 7)
    private Date endDatePrev;

    @Column(name = "COD_STATUS_PROJETO", insertable = true)
    private Integer statusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_STATUS_PROJETO", insertable = false, updatable = false)
    private ProjetoLeilaoStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "DATA_CRIACAO", columnDefinition = "date", length = 7)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    @Column(name = "DATA_ALTERACAO", columnDefinition = "date", length = 7)
    private Date changedAt;

    @Column(name = "INTEGRADO")
    @Type(type = "net.s4bdigital.libs.jpa.usertype.TrueFalseVarcharType")
    private Boolean integrated;

    @Column(name = "COD_GESTOR", length = 9)
    private Long gestorId;

    @Column(name = "COD_DEPARTAMENTO")
    private Integer departamentId;

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

    public UnidadeNegocio getUnidadeNegocio() {
        return unidadeNegocio;
    }

    public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
        this.unidadeNegocio = unidadeNegocio;
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

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
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

    public ProjetoLeilaoStatus getStatus() {
        return status;
    }

    public void setStatus(ProjetoLeilaoStatus status) {
        this.status = status;
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