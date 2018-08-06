package br.org.roger.spring.domain.dto;

/* Created by walter on 30/03/17. */

public class PaymentStatusDTO {

    private Long id;

    private String description;

    private String key;

    public PaymentStatusDTO() {
    }

    public PaymentStatusDTO(Long id, String description, String key) {
        this.id = id;
        this.description = description;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
