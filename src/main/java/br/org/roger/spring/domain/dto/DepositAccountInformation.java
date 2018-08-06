package br.org.roger.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DepositAccountInformation {
    private String bankNumber;
    private String bankName;
    private String identification;
    private String agencyNumber;
    private String agencyDigit;
    private String accountNumber;
    private String accountDigit;
    private BigDecimal value;
    private String accountOwner;
    private String documentNumber;
    private String documentTypeName;
}
