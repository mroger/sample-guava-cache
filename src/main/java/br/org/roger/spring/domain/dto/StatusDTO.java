package br.org.roger.spring.domain.dto;

public class StatusDTO {

    private Integer id;
    private String desc;

    public StatusDTO() {
    }

    public StatusDTO(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
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
}