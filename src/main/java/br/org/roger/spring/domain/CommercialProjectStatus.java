package br.org.roger.spring.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ailson.moreira on 28/07/2017.
 */
@Data
@Entity
@EqualsAndHashCode
@Table(name = "COMMERCIAL_PROJECT_STATUS")
public class CommercialProjectStatus {

    @Id
    @Column(name = "COMMERCIAL_PROJECT_STATUS_ID", unique = true, nullable = false, precision = 4)
    private Integer id;

    @Column(name = "COMMERCIAL_PROJECT_STATUS_DESC", nullable = false, length = 50)
    private String description;
}
