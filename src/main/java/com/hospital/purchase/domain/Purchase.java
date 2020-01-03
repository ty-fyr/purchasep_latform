package com.hospital.purchase.domain;

import java.util.Date;

public class Purchase {
    //采购单Id
    private Integer piId;
    // 药品id
    private Integer drugId;
    //审核结果
    private Integer result;
    //审核意见
    private String opinion;
    //医院id
    private Integer hospitalId;
    //采购单编号
    private Integer purchaseNumber;
    //采购单名称
    private String purchaseName;
    //开始时间
    private Date startTime;
    //结束时间
    private Date overTime;
    //建单时间
    private Date activateTime;
    //提交时间
    private Date submitTime;
    //审核时间
    private Date assessorTime;
    //采购单状态
    private Integer descripId;
    //isdel
    private Integer isdel;
    //审核人
    private String auditor;
    //联系人
    private String contacts;
    //联系人电话
    private String contactsph;
    //供货商id
    private Integer supplierId;
    //交易id
    private Integer tiId;

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName == null ? null : purchaseName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Date getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Date activateTime) {
        this.activateTime = activateTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getAssessorTime() {
        return assessorTime;
    }

    public void setAssessorTime(Date assessorTime) {
        this.assessorTime = assessorTime;
    }

    public Integer getDescripId() {
        return descripId;
    }

    public void setDescripId(Integer descripId) {
        this.descripId = descripId;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactsph() {
        return contactsph;
    }

    public void setContactsph(String contactsph) {
        this.contactsph = contactsph == null ? null : contactsph.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }
}