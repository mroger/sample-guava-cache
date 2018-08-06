package br.org.roger.spring.domain.dto;

import java.util.Date;
import java.util.Objects;

public class EmailDTO {

    private Long id;
    
    private String address;

    private Boolean validated;
    private Date validatedAt;
    private Long userId;
    private Boolean master;

    private String emailConfirmationToken;

    public EmailDTO() {
    }

    public EmailDTO(Long id, String address, Boolean validated, Date validatedAt, Long userId, Boolean master) {
        this.id = id;
        this.address = address;
        this.validated = validated;
        this.validatedAt = validatedAt;
        this.userId = userId;
        this.master = master;
    }

    public Boolean getMaster() {
        return master;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Date getValidatedAt() {
        return validatedAt;
    }

    public void setValidatedAt(Date validatedAt) {
        this.validatedAt = validatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDTO email = (EmailDTO) o;
        return Objects.equals(getId(), email.getId()) &&
                Objects.equals(getAddress(), email.getAddress()) &&
                Objects.equals(getValidated(), email.getValidated()) &&
                Objects.equals(getValidatedAt(), email.getValidatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getValidated(), getValidatedAt());
    }

    public void setMaster(Boolean master) {
        this.master = master;
    }

    public String getEmailConfirmationToken() {
        return emailConfirmationToken;
    }

    public void setEmailConfirmationToken(String emailConfirmationToken) {
        this.emailConfirmationToken = emailConfirmationToken;
    }
}
