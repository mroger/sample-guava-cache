package br.org.roger.spring.domain.dto;

/**
 * Created by eduardo on 08/05/2017.
 */
public enum PaymentStatusEnum {

    NOVO (1, "Novo","new"),
    PRONTO (2, "Pronto","ready"),
    GERADO(3, "Gerado","generated"),
    PAGO(4, "Pago", "paid"),
    CANCELADO(5, "Cancelado", "canceled");

    private Integer id;
    private String description;
    private String key;

    PaymentStatusEnum(Integer id, String description, String key) {
        this.id = id;
        this.description = description;
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
