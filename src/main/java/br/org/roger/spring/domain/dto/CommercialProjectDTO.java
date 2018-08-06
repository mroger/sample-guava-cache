package br.org.roger.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by ailson.moreira on 27/07/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommercialProjectDTO {
    private Long id;
    private String yourReference;
    private String description;
    private Integer statusId;
    private String statusDesc;
    private Date closeAt;
    private Long ownerId;
    private Date createdAt;
    private Date updatedAt;
    private Integer storeId;
}
