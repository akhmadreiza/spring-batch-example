package com.hcid.ftescheduler.model;

public class ArtajasaFileReconHeader {
    private String lineFlag;
    private String status;
    private String partnerInstId;
    private String partnerName;
    private String totalTransaction;
    private String dateTimeReport;

    public ArtajasaFileReconHeader() {
    }

    public ArtajasaFileReconHeader(String lineFlag, String status, String partnerInstId, String partnerName, String totalTransaction, String dateTimeReport) {
        this.lineFlag = lineFlag;
        this.status = status;
        this.partnerInstId = partnerInstId;
        this.partnerName = partnerName;
        this.totalTransaction = totalTransaction;
        this.dateTimeReport = dateTimeReport;
    }

    public String getLineFlag() {
        return lineFlag;
    }

    public void setLineFlag(String lineFlag) {
        this.lineFlag = lineFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPartnerInstId() {
        return partnerInstId;
    }

    public void setPartnerInstId(String partnerInstId) {
        this.partnerInstId = partnerInstId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getTotalTransaction() {
        return totalTransaction;
    }

    public void setTotalTransaction(String totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public String getDateTimeReport() {
        return dateTimeReport;
    }

    public void setDateTimeReport(String dateTimeReport) {
        this.dateTimeReport = dateTimeReport;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "]" +
                " lineFlag: " + lineFlag +
                " status: " + status +
                " partnerInstId: " + partnerInstId +
                " partnerName: " + partnerName +
                " totalTransaction: " + totalTransaction +
                " dateTimeReport: " + dateTimeReport;
    }
}
