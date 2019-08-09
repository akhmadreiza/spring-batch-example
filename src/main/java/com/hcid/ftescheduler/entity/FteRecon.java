package com.hcid.ftescheduler.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "FTE_RECON")
public class FteRecon {
    private String sumId;
    private String id;
    private String dtimeTransaction;
    private String stan;
    private String referenceNo;
    private String senderAccNo;
    private String benefBankCode;
    private String benerAccId;
    private BigDecimal amount;

    public FteRecon() {
    }

    public String getSumId() {
        return sumId;
    }

    public void setSumId(String sumId) {
        this.sumId = sumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDtimeTransaction() {
        return dtimeTransaction;
    }

    public void setDtimeTransaction(String dtimeTransaction) {
        this.dtimeTransaction = dtimeTransaction;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSenderAccNo() {
        return senderAccNo;
    }

    public void setSenderAccNo(String senderAccNo) {
        this.senderAccNo = senderAccNo;
    }

    public String getBenefBankCode() {
        return benefBankCode;
    }

    public void setBenefBankCode(String benefBankCode) {
        this.benefBankCode = benefBankCode;
    }

    public String getBenerAccId() {
        return benerAccId;
    }

    public void setBenerAccId(String benerAccId) {
        this.benerAccId = benerAccId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
