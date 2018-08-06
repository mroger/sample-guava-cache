package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AdvancePayDistPageDTO {

    private Integer start;

    private Integer limit;

    private Long totalAdvance;

    @JsonProperty("advance_list")
    private List<AdvancePaymentDistributionDTO> advanceList;

    public AdvancePayDistPageDTO(Integer start, Integer limit) {
        this.start = start;
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getTotalAdvance() {
        return totalAdvance;
    }

    public void setTotalAdvance(Long totalAdvance) {
        this.totalAdvance = totalAdvance;
    }

    public List<AdvancePaymentDistributionDTO> getAdvanceList() {
        return advanceList;
    }

    public void setAdvanceList(List<AdvancePaymentDistributionDTO> advanceList) {
        this.advanceList = advanceList;
    }
}
