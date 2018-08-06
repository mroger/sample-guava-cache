package br.org.roger.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by abraao.silva on 07/12/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreEntryItemDTO {

    private Long preEntryId;
    private Long paymentItemTypeId;
    private Long paymentAccount;
    private BigDecimal itemPercentage;
    private BigDecimal itemValue;
    private BigDecimal taxValue;
    private Long payee;
}
