package br.org.roger.spring.domain.dto;

public class SellerDTO {

    private Long id;
    private String name;
    private String type;
    private String login;
    private String documentNumber;
    private Integer documentTypeId;
    private String documentTypeName;

    public SellerDTO() {
    }

    public SellerDTO(Long id, String name, String login, String documentNumber, Integer documentTypeId, String documentTypeName) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.documentNumber = documentNumber;
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
    }

    public SellerDTO(Long id, String name, String type, String login, String documentNumber, Integer documentTypeId, String documentTypeName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.login = login;
        this.documentNumber = documentNumber;
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
}