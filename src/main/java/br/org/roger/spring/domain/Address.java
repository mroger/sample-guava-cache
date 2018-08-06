package br.org.roger.spring.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by selma on 09/10/2015.
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements java.io.Serializable{

    @Id
    @GeneratedValue(generator="triggerGenerator")
    @GenericGenerator(name="triggerGenerator", strategy="net.s4bdigital.libs.jpa.TriggerAssignedIdentityGenerator")
    @Column(name = "ADDRESS_ID")
    private Long id;

    public Address() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID", insertable = false, updatable = false)
    private UserEntity userEntity;

    @Column(name = "ENTITY_ID")
    private Long entityId;

    @Column(name = "ADDRESS_STREET_TYPE")
    private String streetType;

    @Column(name = "ADDRESS_STREET")
    @Length(max=85)
    private String street;

    @Column(name = "ADDRESS_NUMBER")
    private String number;

    @Column(name = "ADDRESS_COMPLEMENT")
    @Length(max=120)
    private String complement;

    @Column(name = "ADDRESS_DISTRICT")
    private String district;

    @Column(name = "ADDRESS_CITY")
    @Length(max=65)
    private String city;

    @Column(name = "CEP")
    @Length(max=10)
    private String zipcode;

    @Column(name = "STATE_CODE", nullable = false)
    private String stateCode;

    @Column(name = "ADDRESS_STATE_DESC")
    private String stateDesc;

    @Column(name = "COUNTRY_CODE", nullable = false)
    private Integer countryId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_TYPE_ID", updatable=false, insertable=false)
    private AddressType addressType;

    @Column(name = "ADDRESS_TYPE_ID")
    private Integer type;

    @Column(name = "ADDRESS_STATUS", columnDefinition="char")
    private String status;

    @Transient
    public boolean isOfficialAddres() {
        return AddressType.OFICIAL.equals(getAddressType());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Address other = (Address) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
