package com.hcid.ftescheduler.model;

public class ArtajasaFileRecon {
    private String recordSequence;
    private String dateTimeTransaction;
    private String stan;
    private String referenceNumber;
    private String senderAccountId;
    private String beneficiaryBankCode;
    private String beneficiaryAccountId;
    private String amount;

    public ArtajasaFileRecon() {
    }

    public ArtajasaFileRecon(String recordSequence, String dateTimeTransaction, String stan, String referenceNumber, String senderAccountId, String beneficiaryBankCode, String beneficiaryAccountId, String amount) {
        this.recordSequence = recordSequence;
        this.dateTimeTransaction = dateTimeTransaction;
        this.stan = stan;
        this.referenceNumber = referenceNumber;
        this.senderAccountId = senderAccountId;
        this.beneficiaryBankCode = beneficiaryBankCode;
        this.beneficiaryAccountId = beneficiaryAccountId;
        this.amount = amount;
    }

    public String getDateTimeTransaction() {
        return dateTimeTransaction;
    }

    public void setDateTimeTransaction(String dateTimeTransaction) {
        this.dateTimeTransaction = dateTimeTransaction;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    public void setBeneficiaryBankCode(String beneficiaryBankCode) {
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    public String getBeneficiaryAccountId() {
        return beneficiaryAccountId;
    }

    public void setBeneficiaryAccountId(String beneficiaryAccountId) {
        this.beneficiaryAccountId = beneficiaryAccountId;
    }

    public String getRecordSequence() {
        return recordSequence;
    }

    public void setRecordSequence(String recordSequence) {
        this.recordSequence = recordSequence;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "]" +
                " recordSequence: " + recordSequence +
                " dateTimeTransaction: " + dateTimeTransaction +
                " stan: " + stan +
                " referenceNumber: " + referenceNumber +
                " senderAccountId: " + senderAccountId +
                " beneficiaryBankCode: " + beneficiaryBankCode +
                " beneficiaryAccountId: " + beneficiaryAccountId +
                " amount: " + amount;
    }
}
