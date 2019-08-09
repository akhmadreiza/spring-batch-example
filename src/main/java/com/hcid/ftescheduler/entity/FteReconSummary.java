package com.hcid.ftescheduler.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FTE_RECON_SUMMARY")
public class FteReconSummary {

    @Id
    private String id;
    private String dtimeExecuted;
    private String fileName;
    private String partnerId;
    private String status;
    private String totalTransaction;
    private String dtimeReport;
    private String totalActivate;
    private String totalRetry;
    private String totalManual;
    private String totalInFte;

    public FteReconSummary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDtimeExecuted() {
        return dtimeExecuted;
    }

    public void setDtimeExecuted(String dtimeExecuted) {
        this.dtimeExecuted = dtimeExecuted;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalTransaction() {
        return totalTransaction;
    }

    public void setTotalTransaction(String totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public String getDtimeReport() {
        return dtimeReport;
    }

    public void setDtimeReport(String dtimeReport) {
        this.dtimeReport = dtimeReport;
    }

    public String getTotalActivate() {
        return totalActivate;
    }

    public void setTotalActivate(String totalActivate) {
        this.totalActivate = totalActivate;
    }

    public String getTotalRetry() {
        return totalRetry;
    }

    public void setTotalRetry(String totalRetry) {
        this.totalRetry = totalRetry;
    }

    public String getTotalManual() {
        return totalManual;
    }

    public void setTotalManual(String totalManual) {
        this.totalManual = totalManual;
    }

    public String getTotalInFte() {
        return totalInFte;
    }

    public void setTotalInFte(String totalInFte) {
        this.totalInFte = totalInFte;
    }
}
