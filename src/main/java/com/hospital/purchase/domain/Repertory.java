package com.hospital.purchase.domain;

import java.util.Date;

public class Repertory {
    private Integer repertoryId;

    private String receipt;

    private Integer drugId;

    private Integer invoiceNumber;

    private Date startTime;

    private Date endoplasmicReticulum;

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