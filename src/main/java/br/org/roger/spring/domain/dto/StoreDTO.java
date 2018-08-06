package br.org.roger.spring.domain.dto;

public class StoreDTO {

    private Long id;
    private String desc;
    private Long ownerId;
    private Integer countryId;
    private String countryIso;
    private Integer erpSystem;

    public StoreDTO(Long id, String desc, Long ownerId, Integer countryId, Integer erpSystem, String countryIso) {
        this.id = id;
        this.desc = desc;
        this.ownerId = ownerId;
        this.countryId = countryId;
        this.countryIso = countryIso;
        this.erpSystem = erpSystem;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public Integer getErpSystem() {
        return erpSystem;
    }

    public void setErpSystem(Integer erpSystem) {
        this.erpSystem = erpSystem;
    }
}
