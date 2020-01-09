package com.hospital.purchase.domain;

import java.util.Date;

public class Repertory {
    //库存id
    private Integer repertoryId;
    //入库量
    private String receipt;
    //入库金额
    private Long receiptMoney;
    //药品id
    private Integer drugId;
    //发票号或入库单号
    private Integer invoiceNumber;
    //入库开始时间
    private Date startTime;
    //入库结束时间
    private Date endoplasmicReticulum;

    public Long getReceiptMoney() {
        return receiptMoney;
    }

    public void setReceiptMoney(Long receiptMoney) {
        this.receiptMoney = receiptMoney;
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt == null ? null : receipt.trim();
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndoplasmicReticulum() {
        return endoplasmicReticulum;
    }

    public void setEndoplasmicReticulum(Date endoplasmicReticulum) {
        this.endoplasmicReticulum = endoplasmicReticulum;
    }
}