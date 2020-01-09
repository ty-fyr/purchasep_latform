package com.hospital.purchase.domain;

import com.hospital.purchase.utils.DateUtils;
import lombok.*;

import java.util.Date;
import java.util.Objects;


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
    //库存id
    private Integer repertoryId;
    //库存
    private Repertory repertory;
    //医院对象
    private Hospital hospital;
    //交易对象
    private TransactionInfo transactionInfo;
    //供货商
    private Supplier supplier;
    //医院名称
    private String hospital_name;

    private String startTimeStr;//开始采购时间字符串
    private String overTimeStr;//结束采购时间字符串
    private String activateTimeStr;//建单采购时间字符串
    private String submitTimeStr;//提交采购时间字符串
    private String assessorTimeStr;//审核采购时间字符串
    private String descripIdStr;//采购单状态字符串

    public void transfer() {
        if (Objects.nonNull(this.getStartTime())) {
            this.setStartTimeStr(DateUtils.dateFormat(this.getStartTime(), "yyyy-MM-dd"));
        }
        if (this.getOverTime() != null) {
            this.setOverTimeStr(DateUtils.dateFormat(this.getOverTime(), "yyyy-MM-dd"));
        }
        if (this.getActivateTime() != null) {
            this.setActivateTimeStr(DateUtils.dateFormat(this.getActivateTime(), "yyyy-MM-dd"));
        }
        if (this.getSubmitTime() != null) {
            this.setSubmitTimeStr(DateUtils.dateFormat(this.getSubmitTime(), "yyyy-MM-dd"));
        }
        if (this.getAssessorTime() != null) {
            this.setAssessorTimeStr(DateUtils.dateFormat(this.getAssessorTime(), "yyyy-MM-dd"));
        }
        if (Objects.equals(this.getDescripId(),0)) {
            this.setDescripIdStr("已入库");
        } else if (Objects.equals(this.getDescripId(),1)) {
            this.setDescripIdStr("未入库");
        }
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

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
        this.opinion = opinion;
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
        this.purchaseName = purchaseName;
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
        this.auditor = auditor;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsph() {
        return contactsph;
    }

    public void setContactsph(String contactsph) {
        this.contactsph = contactsph;
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

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getOverTimeStr() {
        return overTimeStr;
    }

    public void setOverTimeStr(String overTimeStr) {
        this.overTimeStr = overTimeStr;
    }

    public String getActivateTimeStr() {
        return activateTimeStr;
    }

    public void setActivateTimeStr(String activateTimeStr) {
        this.activateTimeStr = activateTimeStr;
    }

    public String getSubmitTimeStr() {
        return submitTimeStr;
    }

    public void setSubmitTimeStr(String submitTimeStr) {
        this.submitTimeStr = submitTimeStr;
    }

    public String getAssessorTimeStr() {
        return assessorTimeStr;
    }

    public void setAssessorTimeStr(String assessorTimeStr) {
        this.assessorTimeStr = assessorTimeStr;
    }

    public String getDescripIdStr() {
        return descripIdStr;
    }

    public void setDescripIdStr(String descripIdStr) {
        this.descripIdStr = descripIdStr;
    }
}