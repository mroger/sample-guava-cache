package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by selma on 09/10/2015.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ROLE_DOCUMENT_TYPE")
public class RoleDocumentType implements Serializable {

    public static final String PESSOA_FISICA = "F";
    public static final String PESSOA_JURIDICA = "J";

    @Id
    @Column(name = "ROLE_DOCUMENT_TYPE_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_TYPE_ID", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "DOCUMENT_TYPE_ID")
    private Integer documentTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
    private Role role;

    @Column(name = "ROLE_ID")
    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_CODE", insertable = false, updatable = false)
    private Country country;

    @Column(name = "COUNTRY_CODE")
    private Integer countryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_TYPE_CATEGORY_ID", insertable = false, updatable = false)
    private DocumentTypeCategory category;

    @Column(name = "DOCUMENT_TYPE_CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "ENTITY_TYPE", length = 1)
    private String entityType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public DocumentTypeCategory getCategory() {
        return category;
    }

    public void setCategory(DocumentTypeCategory category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

}
