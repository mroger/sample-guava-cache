package br.org.roger.spring.domain.dto;

import java.util.List;

/**
 * Created by ailson.moreira on 07/04/2017.
 */
public class EntryGroupListDTO {

    private Long total;

    private Integer start;

    private Integer limit;

    private List<EntryGroupDTO> entryGroups;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public List<EntryGroupDTO> getEntryGroups() {
        return entryGroups;
    }

    public void setEntryGroups(List<EntryGroupDTO> entryGroups) {
        this.entryGroups = entryGroups;
    }
}
