package br.org.roger.spring.domain.dto;

import java.util.Date;

public class AuctionDTO {

    private Long id;
    private String desc;
    private Date endDate;

    public AuctionDTO() {
    }

    public AuctionDTO(Long id, String desc, Date endDate) {
        this.id = id;
        this.desc = desc;
        this.endDate = endDate;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}