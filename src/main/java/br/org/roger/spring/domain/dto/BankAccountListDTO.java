package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BankAccountListDTO {

    @JsonProperty("bank_account_list")
    private List<BankAccountDTO> bankAccountDTOList;

    public List<BankAccountDTO> getBankAccountDTOList() {
        return bankAccountDTOList;
    }

    public void setBankAccountDTOList(List<BankAccountDTO> bankAccountDTOList) {
        this.bankAccountDTOList = bankAccountDTOList;
    }
}