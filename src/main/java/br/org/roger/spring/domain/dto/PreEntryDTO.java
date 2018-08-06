package br.org.roger.spring.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by abraao.silva on 05/12/2017.
 */

@Data
public class PreEntryDTO {

    private Long id;

    private Integer preEntryStatusId;

    private Integer preEntryTypeId;

    private Long sallerId;

    private List<PreEntryItemDTO> preEntryItems;

    private Long payerId;

    private BigDecimal amountLot;

    private BigDecimal amountPurchased;

    private BigDecimal valueBid;

    private Integer codClassFiscal;

    private Long groupOfferId;

    private Boolean calculatedTax;

    private Integer codERPSystem;

    private String erpKey;

    private Long codGestor;

    public PreEntryDTO() {
    }

    public PreEntryDTO(Long id, Integer preEntryStatusId, Integer preEntryTypeId, Long sallerId,
                       Long payerId, BigDecimal amountLot, BigDecimal amountPurchased, BigDecimal valueBid,
                       Integer codClassFiscal, Long groupOfferId, Boolean calculatedTax, Integer codERPSystem,
                       String erpKey, Long codGestor) {
        this.id = id;
        this.preEntryStatusId = preEntryStatusId;
        this.preEntryTypeId = preEntryTypeId;
        this.sallerId = sallerId;
        this.payerId = payerId;
        this.amountLot = amountLot;
        this.amountPurchased = amountPurchased;
        this.valueBid = valueBid;
        this.codClassFiscal =codClassFiscal;
        this.groupOfferId = groupOfferId;
        this.calculatedTax = calculatedTax;
        this.codERPSystem = codERPSystem;
        this.erpKey = erpKey;
        this.codGestor = codGestor;
    }

    public PreEntryDTO(Long id, Boolean calculatedTax, Integer codERPSystem, String erpKey, Integer codClassFiscal, Long codGestor) {
        this.id = id;
        this.calculatedTax = calculatedTax;
        this.codERPSystem = codERPSystem;
        this.erpKey = erpKey;
        this.codClassFiscal =codClassFiscal;
        this.codGestor = codGestor;
    }
}




