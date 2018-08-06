package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuctionListDTO {

    @JsonProperty("auction_list")
    private List<AuctionDTO> auctionDTOList;

    public List<AuctionDTO> getAuctionDTOList() {
        return auctionDTOList;
    }

    public void setAuctionDTOList(List<AuctionDTO> auctionDTOList) {
        this.auctionDTOList = auctionDTOList;
    }
}