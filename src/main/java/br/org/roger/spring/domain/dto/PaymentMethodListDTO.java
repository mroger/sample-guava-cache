package br.org.roger.spring.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaymentMethodListDTO {

    @JsonProperty("payment_method_list")
    private List<PaymentMethodDTO> paymentMethodDTOList;

    public List<PaymentMethodDTO> getPaymentMethodDTOList() {
        return paymentMethodDTOList;
    }

    public void setPaymentMethodDTOList(List<PaymentMethodDTO> paymentMethodDTOList) {
        this.paymentMethodDTOList = paymentMethodDTOList;
    }
}