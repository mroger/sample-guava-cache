package br.org.roger.spring.domain.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by chen on 02/08/2016.
 */
@Data
public class PurchasePaymentDTO {

    private Long id;
    private Long purchaseId;
    private Integer paymentStatusId;
    private Integer cancelCauseId;
    private Integer paymentMethodId;
    private String paymentInstruction;
    private String paymentURL;
    private String pspCheckoutId;
    private Date paidAt;
    private Long auctioneerReceiptId;
    private Boolean paymentAvailable;
    private Long paymentId;
    private List<PurchasePaymentItemDTO> paymentItems;
    private DepositAccountInformation depositAccountInformation;

    public PurchasePaymentDTO() {
    }

    public String getPaymentURL() {
        return paymentURL;
    }

    public void setPaymentURL(String paymentURL) {
        this.paymentURL = paymentURL;
    }

    public PurchasePaymentDTO(
            Long id, Long purchaseId, Integer paymentStatusId, Long auctioneerReceiptId, String paymentInstruction,
            Date paidAt, Integer cancelCauseId, Integer paymentMethodId, String nossoNumero, String identificador, Long pagamentoId) {

        this.id = id;
        this.purchaseId = purchaseId;
        this.paymentStatusId = paymentStatusId;
        this.auctioneerReceiptId = auctioneerReceiptId;
        this.paymentInstruction = paymentInstruction;
        this.paidAt = paidAt;
        this.cancelCauseId = cancelCauseId;
        this.paymentMethodId = paymentMethodId;
        this.paymentAvailable = nossoNumero != null || identificador != null;
        this.paymentId = pagamentoId;

    }
}
