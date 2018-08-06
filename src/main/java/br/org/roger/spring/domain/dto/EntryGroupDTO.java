package br.org.roger.spring.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by ailson.moreira on 07/04/2017.
 */
@Data
@NoArgsConstructor
public class EntryGroupDTO {
    private Long id;
    private Long saleOrderId;
    private Long paymentId;
    private Integer statusId;
    private String statusDesc;
    private Long auctionId;
    private Integer lotNumber;
    private String subLote;
    private String shortDesc;
    private String currency;
    private Long payerId;
    private Long payeeId;
    private Long sellerId;
    private Date createdAt;
    private Date expiresAt;
    private Date paidAt;
    private Date paymentDistApprovedAt;
    private Date paymentDistAt;
    private Date canceledAt;
    private Date payCanceledAt;
    private Integer methodPaymentId;
    private String methodPaymentDesc;
    private List<IntegrationDTO> integrations;
    private List<EntryDTO> entries;
    private PaymentAccountDTO paymentAccount;
    private ProductFinancialDTO productFinancial;
    private CommercialProjectDTO commercialProject;

    public EntryGroupDTO(Long id, Long saleOrderId, Integer statusId, String statusDesc, Long auctionId, Integer
            lotNumber, String subLote, String shortDesc, String currency, Long payerId, Long payeeId, Date createdAt,
                         Date expiresAt, Date paidAt, Date paymentDistApprovedAt, Date paymentDistAt, Date
                                 canceledAt, Integer methodPaymentId, String methodPaymentDesc, Long idPaymentAccount,
                         Integer paymentMethodId, String paymentMethodDesc, Integer payAccStId, String
                                 payAccStDesc, Integer wallet, Boolean registeredCharge, Long bankAccId, String
                                 bankAccNro, String bankAccDig, String
                                 bankAg, String bankAgDig, String bankNro, String bankName, Long prodId, Integer
                                 codClassFiscal, String descFat, Long cProjId, String yourRef, String cProjDesc, Integer
                                 cProjSTId, String cProjSTDesc, Date
                                 cProjCloseDate, Long cProjOwner, Date
                                 cProjCreateAt, Date cProjUpdateAt, Integer storeId, Long paymentId, Long sellerId) {

        /**/

        this.id = id;
        this.saleOrderId = saleOrderId;
        this.sellerId = sellerId;
        this.paymentId = paymentId;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
        this.auctionId = auctionId;
        this.lotNumber = lotNumber;
        this.subLote = subLote;
        this.shortDesc = shortDesc;
        this.currency = currency;
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.paidAt = paidAt;
        this.paymentDistApprovedAt = paymentDistApprovedAt;
        this.paymentDistAt = paymentDistAt;
        this.canceledAt = canceledAt;
        this.methodPaymentId = methodPaymentId;
        this.methodPaymentDesc = methodPaymentDesc;
        this.paymentAccount = new PaymentAccountDTO(idPaymentAccount, paymentMethodId, paymentMethodDesc,
                payAccStId, payAccStDesc, wallet, registeredCharge, new BankAccountDTO(bankAccId, bankAccNro,
                bankAccDig, bankAg, bankAgDig, bankNro, bankName));

        if (prodId != null) {
            this.productFinancial = new ProductFinancialDTO(prodId, codClassFiscal, descFat);
        }

        if (cProjId != null) {
            this.commercialProject = new CommercialProjectDTO(cProjId, yourRef, cProjDesc, cProjSTId, cProjSTDesc,
                    cProjCloseDate, cProjOwner, cProjCreateAt, cProjUpdateAt, storeId);
        }
    }
}
