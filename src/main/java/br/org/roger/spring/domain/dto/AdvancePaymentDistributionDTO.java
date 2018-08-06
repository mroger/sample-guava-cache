package br.org.roger.spring.domain.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by chen on 11/09/2015.
 */
public class AdvancePaymentDistributionDTO {

    private Long id;
    private Long auctionId;
    private Date auctionEndDate;
    private Long sellerId;
    private String sellerName;
    private Integer sellerDocumentType;
    private String sellerDocument;
    private Long originUserEntityId;
    private String originUserEntityName;
    private Long originPaymentAccountId;
    private Long destinyUserEntityId;
    private String destinyUserEntityName;
    private Integer destinyUserEntityDocumentType;
    private String destinyUserEntityDocument;
    private Long destinyAccountId;
    private String destinyBankAgency;
    private String destinyBankAgencyDig;
    private String destinyBankAccount;
    private String destinyBankAccountDig;
    private String destinyBankNumber;
    private String destinyBankName;
    private Integer paymentMethodId;
    private String paymentMethodName;
    private Integer transferTypeId;
    private String transferTypeName;
    private String transferTypeSigla;
    private BigDecimal advanceValue;
    private Date scheduledAt;
    private Date paymentDistributedAt;
    private Date cancelPaymentDistributedAt;
    private Date integratedAt;
    private Date canceledAt;
    private Date createdAt;
    private Date updatedAt;
    private Boolean approved;
    private String comment;
    private Integer integrationStatusId;
    private String integrationStatusDesc;
    private Boolean integration;
    private Integer statusId;
    private String statusDesc;
    private List<CostCenterDTO> costCenterList;

    public AdvancePaymentDistributionDTO() {
    }

    public AdvancePaymentDistributionDTO(Long id, Long auctionId, Date auctionEndDate, Long sellerId, String sellerName, Integer sellerDocumentType, String sellerDocument, Long originUserEntityId, String originUserEntityName, Long originPaymentAccountId,
                                         Long destinyUserEntityId, String destinyUserEntityName, Integer destinyUserEntityDocumentType, String destinyUserEntityDocument,
                                         Long destinyAccountId, String destinyBankAgency, String destinyBankAgencyDig, String destinyBankAccount, String destinyBankAccountDig,
                                         String destinyBankNumber, String destinyBankName, Integer paymentMethodId, String paymentMethodName, Integer transferTypeId,
                                         String transferTypeName, String transferTypeSigla, BigDecimal advanceValue, Date scheduledAt, Date paymentDistributedAt, Date integratedAt,
                                         Date canceledAt, Date createdAt, Date updatedAt, Boolean approved, String comment, Integer integrationStatusId,
                                         String integrationStatusDesc, Boolean integration, Integer statusId, String statusDesc) {
        this.id = id;
        this.auctionId = auctionId;
        this.auctionEndDate = auctionEndDate;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerDocumentType = sellerDocumentType;
        this.sellerDocument = sellerDocument;
        this.originUserEntityId = originUserEntityId;
        this.originUserEntityName = originUserEntityName;
        this.originPaymentAccountId = originPaymentAccountId;
        this.destinyUserEntityId = destinyUserEntityId;
        this.destinyUserEntityName = destinyUserEntityName;
        this.destinyUserEntityDocumentType = destinyUserEntityDocumentType;
        this.destinyUserEntityDocument = destinyUserEntityDocument;
        this.destinyAccountId = destinyAccountId;
        this.destinyBankAgency = destinyBankAgency;
        this.destinyBankAgencyDig = destinyBankAgencyDig;
        this.destinyBankAccount = destinyBankAccount;
        this.destinyBankAccountDig = destinyBankAccountDig;
        this.destinyBankNumber = destinyBankNumber;
        this.destinyBankName = destinyBankName;
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodName = paymentMethodName;
        this.transferTypeId = transferTypeId;
        this.transferTypeName = transferTypeName;
        this.transferTypeSigla =transferTypeSigla;
        this.advanceValue = advanceValue;
        this.scheduledAt = scheduledAt;
        this.paymentDistributedAt = paymentDistributedAt;
        this.integratedAt = integratedAt;
        this.canceledAt = canceledAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.approved = approved;
        this.comment = comment;
        this.integrationStatusId = integrationStatusId;
        this.integrationStatusDesc = integrationStatusDesc;
        this.integration = integration;
        this.statusId = statusId;
        this.statusDesc = statusDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getSellerDocumentType() {
        return sellerDocumentType;
    }

    public void setSellerDocumentType(Integer sellerDocumentType) {
        this.sellerDocumentType = sellerDocumentType;
    }

    public String getSellerDocument() {
        return sellerDocument;
    }

    public void setSellerDocument(String sellerDocument) {
        this.sellerDocument = sellerDocument;
    }

    public Long getOriginPaymentAccountId() {
        return originPaymentAccountId;
    }

    public void setOriginPaymentAccountId(Long originPaymentAccountId) {
        this.originPaymentAccountId = originPaymentAccountId;
    }

    public Long getDestinyAccountId() {
        return destinyAccountId;
    }

    public void setDestinyAccountId(Long destinyAccountId) {
        this.destinyAccountId = destinyAccountId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(Integer transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public BigDecimal getAdvanceValue() {
        return advanceValue;
    }

    public void setAdvanceValue(BigDecimal advanceValue) {
        this.advanceValue = advanceValue;
    }

    public Date getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getOriginUserEntityId() {
        return originUserEntityId;
    }

    public void setOriginUserEntityId(Long originUserEntityId) {
        this.originUserEntityId = originUserEntityId;
    }

    public Integer getIntegrationStatusId() {
        return integrationStatusId;
    }

    public void setIntegrationStatusId(Integer integrationStatusId) {
        this.integrationStatusId = integrationStatusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getPaymentDistributedAt() {
        return paymentDistributedAt;
    }

    public void setPaymentDistributedAt(Date paymentDistributedAt) {
        this.paymentDistributedAt = paymentDistributedAt;
    }

    public Date getIntegratedAt() {
        return integratedAt;
    }

    public void setIntegratedAt(Date integratedAt) {
        this.integratedAt = integratedAt;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Long getDestinyUserEntityId() {
        return destinyUserEntityId;
    }

    public void setDestinyUserEntityId(Long destinyUserEntityId) {
        this.destinyUserEntityId = destinyUserEntityId;
    }

    public String getOriginUserEntityName() {
        return originUserEntityName;
    }

    public void setOriginUserEntityName(String originUserEntityName) {
        this.originUserEntityName = originUserEntityName;
    }

    public String getDestinyUserEntityName() {
        return destinyUserEntityName;
    }

    public void setDestinyUserEntityName(String destinyUserEntityName) {
        this.destinyUserEntityName = destinyUserEntityName;
    }

    public String getDestinyUserEntityDocument() {
        return destinyUserEntityDocument;
    }

    public void setDestinyUserEntityDocument(String destinyUserEntityDocument) {
        this.destinyUserEntityDocument = destinyUserEntityDocument;
    }

    public String getDestinyBankAgency() {
        return destinyBankAgency;
    }

    public void setDestinyBankAgency(String destinyBankAgency) {
        this.destinyBankAgency = destinyBankAgency;
    }

    public String getDestinyBankAgencyDig() {
        return destinyBankAgencyDig;
    }

    public void setDestinyBankAgencyDig(String destinyBankAgencyDig) {
        this.destinyBankAgencyDig = destinyBankAgencyDig;
    }

    public String getDestinyBankAccount() {
        return destinyBankAccount;
    }

    public void setDestinyBankAccount(String destinyBankAccount) {
        this.destinyBankAccount = destinyBankAccount;
    }

    public String getDestinyBankAccountDig() {
        return destinyBankAccountDig;
    }

    public void setDestinyBankAccountDig(String destinyBankAccountDig) {
        this.destinyBankAccountDig = destinyBankAccountDig;
    }

    public String getDestinyBankNumber() {
        return destinyBankNumber;
    }

    public void setDestinyBankNumber(String destinyBankNumber) {
        this.destinyBankNumber = destinyBankNumber;
    }

    public String getDestinyBankName() {
        return destinyBankName;
    }

    public void setDestinyBankName(String destinyBankName) {
        this.destinyBankName = destinyBankName;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getTransferTypeName() {
        return transferTypeName;
    }

    public void setTransferTypeName(String transferTypeName) {
        this.transferTypeName = transferTypeName;
    }

    public String getIntegrationStatusDesc() {
        return integrationStatusDesc;
    }

    public void setIntegrationStatusDesc(String integrationStatusDesc) {
        this.integrationStatusDesc = integrationStatusDesc;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Boolean getIntegration() {
        return integration;
    }

    public void setIntegration(Boolean integration) {
        this.integration = integration;
    }

    public Integer getDestinyUserEntityDocumentType() {
        return destinyUserEntityDocumentType;
    }

    public void setDestinyUserEntityDocumentType(Integer destinyUserEntityDocumentType) {
        this.destinyUserEntityDocumentType = destinyUserEntityDocumentType;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getTransferTypeSigla() {
        return transferTypeSigla;
    }

    public void setTransferTypeSigla(String transferTypeSigla) {
        this.transferTypeSigla = transferTypeSigla;
    }

    public List<CostCenterDTO> getCostCenterList() {
        return costCenterList;
    }

    public void setCostCenterList(List<CostCenterDTO> costCenterList) {
        this.costCenterList = costCenterList;
    }

    public Date getCancelPaymentDistributedAt() {
        return cancelPaymentDistributedAt;
    }

    public void setCancelPaymentDistributedAt(Date cancelPaymentDistributedAt) {
        this.cancelPaymentDistributedAt = cancelPaymentDistributedAt;
    }

    @Override
    public String toString() {
        return "AdvancePaymentDistributionDTO{" +
                "id=" + id +
                ", auctionId=" + auctionId +
                ", sellerId=" + sellerId +
                ", sellerName='" + sellerName + '\'' +
                ", originUserEntityId=" + originUserEntityId +
                ", originUserEntityName='" + originUserEntityName + '\'' +
                ", originPaymentAccountId=" + originPaymentAccountId +
                ", destinyUserEntityId=" + destinyUserEntityId +
                ", destinyUserEntityName='" + destinyUserEntityName + '\'' +
                ", destinyUserEntityDocumentType=" + destinyUserEntityDocumentType +
                ", destinyUserEntityDocument='" + destinyUserEntityDocument + '\'' +
                ", destinyAccountId=" + destinyAccountId +
                ", destinyBankAgency='" + destinyBankAgency + '\'' +
                ", destinyBankAgencyDig='" + destinyBankAgencyDig + '\'' +
                ", destinyBankAccount='" + destinyBankAccount + '\'' +
                ", destinyBankAccountDig='" + destinyBankAccountDig + '\'' +
                ", destinyBankNumber='" + destinyBankNumber + '\'' +
                ", destinyBankName='" + destinyBankName + '\'' +
                ", paymentMethodId=" + paymentMethodId +
                ", paymentMethodName='" + paymentMethodName + '\'' +
                ", transferTypeId=" + transferTypeId +
                ", transferTypeName='" + transferTypeName + '\'' +
                ", transferTypeSigla='" + transferTypeSigla + '\'' +
                ", advanceValue=" + advanceValue +
                ", scheduledAt=" + scheduledAt +
                ", paymentDistributedAt=" + paymentDistributedAt +
                ", cancelPaymentDistributedAt=" + cancelPaymentDistributedAt +
                ", integratedAt=" + integratedAt +
                ", canceledAt=" + canceledAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", approved=" + approved +
                ", comment='" + comment + '\'' +
                ", integrationStatusId=" + integrationStatusId +
                ", integrationStatusDesc='" + integrationStatusDesc + '\'' +
                ", integration=" + integration +
                ", statusId=" + statusId +
                ", statusDesc='" + statusDesc + '\'' +
                '}';
    }
}