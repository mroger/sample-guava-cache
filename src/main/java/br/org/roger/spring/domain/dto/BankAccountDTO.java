package br.org.roger.spring.domain.dto;

public class BankAccountDTO {
    private String entityName;
    private Long accountId;
    private Long paymentAccountId;
    private String bankNumber;
    private String bankName;
    private String bankAgency;
    private String bankAgencyDig;
    private String bankAccount;
    private String bankAccountDig;

    public BankAccountDTO() {
    }

    public BankAccountDTO(Long accountId, String bankAccount, String bankAccountDig, String bankAgency, String
            bankAgencyDig, String bankNumber, String bankName) {
        this.accountId = accountId;
        this.bankAccount = bankAccount;
        this.bankAccountDig = bankAccountDig;
        this.bankAgency = bankAgency;
        this.bankAgencyDig = bankAgencyDig;
        this.bankNumber = bankNumber;
        this.bankName = bankName;
    }

    public BankAccountDTO(String bankNumber, String bankName, String bankAgency, String bankAgencyDig, String
            bankAccount, String bankAccountDig) {
        this.bankNumber = bankNumber;
        this.bankName = bankName;
        this.bankAgency = bankAgency;
        this.bankAgencyDig = bankAgencyDig;
        this.bankAccount = bankAccount;
        this.bankAccountDig = bankAccountDig;
    }

    public BankAccountDTO(String entityName, Long accountId, String bankNumber, String bankName, String bankAgency,
                          String bankAgencyDig, String bankAccount, String bankAccountDig) {
        this.entityName = entityName;
        this.accountId = accountId;
        this.bankNumber = bankNumber;
        this.bankName = bankName;
        this.bankAgency = bankAgency;
        this.bankAgencyDig = bankAgencyDig;
        this.bankAccount = bankAccount;
        this.bankAccountDig = bankAccountDig;
    }

    public BankAccountDTO(String entityName, Long accountId, Long paymentAccountId, String bankNumber, String
            bankName, String bankAgency, String bankAgencyDig, String bankAccount, String bankAccountDig) {
        this.entityName = entityName;
        this.accountId = accountId;
        this.paymentAccountId = paymentAccountId;
        this.bankNumber = bankNumber;
        this.bankName = bankName;
        this.bankAgency = bankAgency;
        this.bankAgencyDig = bankAgencyDig;
        this.bankAccount = bankAccount;
        this.bankAccountDig = bankAccountDig;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId(Long paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAgency() {
        return bankAgency;
    }

    public void setBankAgency(String bankAgency) {
        this.bankAgency = bankAgency;
    }

    public String getBankAgencyDig() {
        return bankAgencyDig;
    }

    public void setBankAgencyDig(String bankAgencyDig) {
        this.bankAgencyDig = bankAgencyDig;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccountDig() {
        return bankAccountDig;
    }

    public void setBankAccountDig(String bankAccountDig) {
        this.bankAccountDig = bankAccountDig;
    }
}
