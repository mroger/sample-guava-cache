package br.org.roger.spring.domain.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PhoneDTO {

    private Long id;
    private Integer type;

    @NotNull(message = "phone_ddi_cannot_be_null")
    @Min(value = 1, message = "phone_ddi_minsize_not_reached")
    @Length(max = 4, message = "phone_ddi_maxsize_exceeded")
    private String ddi;

    @Min(value = 1, message = "phone_ddd_minsize_not_reached")
    @Length(max = 5, message = "phone_ddd_maxsize_exceeded")
    private String ddd;

    @NotNull(message = "phone_number_cannot_be_null")
    @Min(value = 1, message = "phone_number_minsize_not_reached")
    @Length(max = 16, message = "phone_number_maxsize_exceeded")
    private String number;

    private Long userId;

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, Integer type, String ddi, String ddd, String number, Long userId) {
        this.id = id;
        this.type = type;
        this.ddi = ddi;
        this.ddd = ddd;
        this.number = number;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneDTO phone = (PhoneDTO) o;
        return Objects.equals(getId(), phone.getId()) &&
                Objects.equals(getType(), phone.getType()) &&
                Objects.equals(getNumber(), phone.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getNumber());
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

}
