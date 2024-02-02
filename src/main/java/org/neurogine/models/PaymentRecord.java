package org.neurogine.models;

public class PaymentRecord {

    private String date;
    private String referenceNo;
    private Double amount;
    private String status;
    private String remark;

    public PaymentRecord(){}

    public PaymentRecord(String date, String referenceNo, double amount, String status, String remark) {
        this.date = date;
        this.referenceNo = referenceNo;
        this.amount = amount;
        this.status = status;
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
