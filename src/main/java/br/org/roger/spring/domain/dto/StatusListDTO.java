package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StatusListDTO {

    @JsonProperty("status_list")
    private List<StatusDTO> statusDTOList;

    public List<StatusDTO> getStatusDTOList() {
        return statusDTOList;
    }

    public void setStatusDTOList(List<StatusDTO> statusDTOList) {
        this.statusDTOList = statusDTOList;
    }
}