package com.hospital.purchase.domain;

public class SupplierManagement {
    private Integer supplyId;

    private String reviewResults;

    private Integer supplierId;

    private Integer drugId;

    private Integer drugTransactionStatus;

    private Integer isdel;

    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Integer getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Integer supplyId) {
        this.supplyId = supplyId;
    }

    public String getReviewResults() {
        return reviewResults;
    }

    public void setReviewResults(String reviewResults) {
        this.reviewResults = reviewResults == null ? null : reviewResults.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getDrugTransactionStatus() {
        return drugTransactionStatus;
    }

    public void setDrugTransactionStatus(Integer drugTransactionStatus) {
        this.drugTransactionStatus = drugTransactionStatus;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}