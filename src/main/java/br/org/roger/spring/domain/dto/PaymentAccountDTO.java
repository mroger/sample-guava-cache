package br.org.roger.spring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ailson.moreira on 24/07/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccountDTO {
    private Long id;
    private Integer paymentMethodId;
    private String paymentMethodDesc;
    private Integer statusId;
    private String statusDesc;
    private Integer wallet;
    private Boolean registeredCharge;
    private BankAccountDTO bankAccount;
}
