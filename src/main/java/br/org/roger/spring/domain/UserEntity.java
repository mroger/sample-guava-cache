package br.org.roger.spring.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENTITY")
@NamedQueries({
        @NamedQuery(name = UserEntity.Queries.FIND_ACTIVE_USER_SELLER_WITH_ACCOUNT_BR,
                query =
                        " SELECT " +
                                "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.SellerDTO( " +
                                "     ue.id, " +
                                "     ue.name, " +
                                "     ue.entityType, " +
                                "     l.loginName, " +
                                "     d.numero, " +
                                "     dt.id, " +
                                "     dt.name) " +
                                " FROM " +
                                "	UserEntity ue " +
                                "	inner join ue.login l " +
                                "	inner join ue.documents d " +
                                "	inner join d.documentType dt " +
                                "   inner join ue.contas c " +
                                " WHERE " +
                                "	ue.entityStatusId = " + UserEntity.STATUS_ACTIVE +
                                " AND ( " +
                                "( ue.entityType = 'J' AND dt.id = " + DocumentType.CNPJ + " ) " +
                                "   OR  " +
                                "( ue.entityType = 'F' AND dt.id = " + DocumentType.CPF + " )) "),

        @NamedQuery(name = UserEntity.Queries.FIND_BRANCHE_USER_ENTITY_BR,
        query =
                " SELECT " +
                        "   new net.s4bdigital.api.auctionfinancial.server.domain.dto.SellerDTO( " +
                        "     ue.id, " +
                        "     ue.name, " +
                        "     l.loginName, " +
                        "     d.numero, " +
                        "     dt.id, " +
                        "     dt.name) " +
                        " FROM " +
                        "	UserEntity ue " +
                        "	inner join ue.login l " +
                        "	inner join ue.documents d " +
                        "	inner join d.documentType dt " +
                        " WHERE " +
                        "   dt.id = " + DocumentType.CNPJ  +
                        "   and d.numero like :documentNumber ")
})
public class UserEntity implements Serializable {

    public static final int STATUS_ACTIVE = 1;

    public static final class Queries {
        public static final String FIND_ACTIVE_USER_SELLER_WITH_ACCOUNT_BR = "FIND_ACTIVE_USER_SELLER_WITH_ACCOUNT_BR";
        public static final String FIND_BRANCHE_USER_ENTITY_BR = "FIND_BRANCHE_USER_ENTITY_BR";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTITY_ID")
    private Long id;

    @Column(name = "ENTITY_NAME")
    private String name;

    @Column(name = "ENTITY_TYPE")
    private String entityType;

    @Column(name = "ENTITY_STATUS_ID")
    private Integer entityStatusId;

    @OneToOne(mappedBy = "entity", fetch = FetchType.LAZY)
    private Login login;

    @OneToOne(mappedBy = "entity", fetch = FetchType.LAZY)
    private NumberSequence numberSequence;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<Document> documents;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<Address> address;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<Conta> contas;

    @Column(name = "COUNTRY_CODE")
    private Long countryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Integer getEntityStatusId() {
        return entityStatusId;
    }

    public void setEntityStatusId(Integer entityStatusId) {
        this.entityStatusId = entityStatusId;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public NumberSequence getNumberSequence() {
        return numberSequence;
    }

    public void setNumberSequence(NumberSequence numberSequence) {
        this.numberSequence = numberSequence;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
