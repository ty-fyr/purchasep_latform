package com.hospital.purchase.domain;

import java.util.Date;
import java.util.List;

public class Supplier {
    private Integer supplierId;

    private String supplierName;

    private String registeredAddress;

    private String businessLicense;

    private Date registrationTime;

    private Integer druginId;

    public Integer getDruginId() {
        return druginId;
    }

    public void setDruginId(Integer druginId) {
        this.druginId = druginId;
    }


    //库存
    private Repertory repertory;
    //医院对象
    private Hospital hospital;
    //交易对象
    private TransactionInfo transactionInfo;
    //供货商对象
    private Purchase purchase;
    //药品信息对象
    private DrugInformationSheet drugInformationSheet;

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }


    public DrugInformationSheet getDrugInformationSheet() {
        return drugInformationSheet;
    }

    public void setDrugInformationSheet(DrugInformationSheet drugInformationSheet) {
        this.drugInformationSheet = drugInformationSheet;
    }




    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
}