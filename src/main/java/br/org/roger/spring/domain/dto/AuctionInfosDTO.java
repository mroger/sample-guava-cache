package br.org.roger.spring.domain.dto;

import java.util.Date;

/**
 * Created by chen on 16/09/2015.
 */
public class AuctionInfosDTO {

    Long id;
    String description;
    Date endDate;

    public AuctionInfosDTO(Long id, String description, Date endDate) {
        this.id = id;
        this.description = description;
        this.endDate = endDate;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
