package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SellerListDTO {

    @JsonProperty("seller_list")
    private List<SellerDTO> sellerDTOList;

    public List<SellerDTO> getSellerDTOList() {
        return sellerDTOList;
    }

    public void setSellerDTOList(List<SellerDTO> sellerDTOList) {
        this.sellerDTOList = sellerDTOList;
    }
}