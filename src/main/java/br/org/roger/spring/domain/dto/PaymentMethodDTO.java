package br.org.roger.spring.domain.dto;

public class PaymentMethodDTO {

    private Integer id;
    private String desc;
    private String sigla;

    public PaymentMethodDTO() {
    }

    public PaymentMethodDTO(Integer id, String desc, String sigla) {
        this.id = id;
        this.desc = desc;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}