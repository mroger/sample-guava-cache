package br.org.roger.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ailson.moreira on 26/07/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFinancialDTO {
    private Long productId;
    private Integer taxClassification;
    private String invoiceDescription;
}
