package br.org.roger.spring.domain.dto;

import java.util.List;

/**
 * Created by ailson on 07/11/2016.
 */
public class ProjectListDTO {

    private Long total;

    private Integer start;

    private Integer limit;

    private List<ProjectDTO> projects;

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

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}