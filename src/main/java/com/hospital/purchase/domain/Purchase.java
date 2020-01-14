package com.hospital.purchase.domain;

import com.hospital.purchase.utils.DateUtils;
import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;


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
    //供货商对象
    private Supplier supplier;
    //药品信息对象
    private DrugInformationSheet drugInformationSheet;
    //生产企业对象
    private Enterprise enterprise;


    //医院名称
    private String hospital_name;

    //单位
    private Units units;

    private String resultStr;

    private String startTimeStr;//开始采购时间字符串
    private String overTimeStr;//结束采购时间字符串
    private String activateTimeStr;//建单采购时间字符串
    private String submitTimeStr;//提交采购时间字符串
    private String assessorTimeStr;//审核采购时间字符串
    private String descripIdStr;//采购单状态字符串

    /**
     * 导出供应商查询信息
     *
     * @param index
     * @return
     */
    public String format2OutputCsv(Integer index) {
        StringJoiner sj = new StringJoiner(",");
        if (Objects.nonNull(index)) {
            sj.add(index + "");
        }
        return sj.add(this.supplier.getSupplierName())
                .add(this.descripIdStr)
                .add(this.transactionInfo.getOrderQuantity() + "")
                .add(this.transactionInfo.getOrderAmount() + "")
                .add(this.transactionInfo.getDeliveryVolume() + "")
                .add(this.transactionInfo.getDeliveryAmount() + "")
                .toString();
    }

    /**
     * 导出采购单查询信息
     *
     * @param index
     * @return
     */
    public String formatToOutputCsv(Integer index) {
        StringJoiner sj = new StringJoiner(",");
        if (Objects.nonNull(index)) {
            sj.add(index + "");
        }
        return sj.add(this.hospital.getHospitalName())
                .add(this.purchaseNumber + "")
                .add(this.purchaseName)
                .add(this.descripIdStr)
                .add(this.startTimeStr)
                .add(this.overTimeStr)
                .add(this.activateTimeStr)
                .add(this.submitTimeStr)
                .add(this.activateTimeStr)
                .add(this.transactionInfo.getOrderQuantity() + "")
                .add(this.transactionInfo.getOrderAmount() + "")
                .toString();
    }

    public String formatAndOutputCsv(Integer index) {
        StringJoiner sj = new StringJoiner(",");
        if (Objects.nonNull(index)) {
            sj.add(index + "");
        }
        return sj.add(this.hospital.getHospitalName())
                .add(this.descripIdStr)
                .add(this.transactionInfo.getOrderQuantity() + "")
                .add(this.transactionInfo.getOrderAmount() + "")
                .add(this.repertory.getReceipt())
                .add(this.repertory.getReceiptMoney() + "")
                .toString();
    }

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
        if (Objects.equals(this.getDescripId(), 0)) {
            this.setDescripIdStr("已入库");
        } else if (Objects.equals(this.getDescripId(), 1)) {
            this.setDescripIdStr("未入库");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Purchase{");
        sb.append("piId=").append(piId);
        sb.append(", drugId=").append(drugId);
        sb.append(", result=").append(result);
        sb.append(", opinion='").append(opinion).append('\'');
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", purchaseNumber=").append(purchaseNumber);
        sb.append(", purchaseName='").append(purchaseName).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", overTime=").append(overTime);
        sb.append(", activateTime=").append(activateTime);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", assessorTime=").append(assessorTime);
        sb.append(", descripId=").append(descripId);
        sb.append(", isdel=").append(isdel);
        sb.append(", auditor='").append(auditor).append('\'');
        sb.append(", contacts='").append(contacts).append('\'');
        sb.append(", contactsph='").append(contactsph).append('\'');
        sb.append(", supplierId=").append(supplierId);
        sb.append(", tiId=").append(tiId);
        sb.append(", repertoryId=").append(repertoryId);
        sb.append(", repertory=").append(repertory);
        sb.append(", hospital=").append(hospital);
        sb.append(", transactionInfo=").append(transactionInfo);
        sb.append(", supplier=").append(supplier);
        sb.append(", drugInformationSheet=").append(drugInformationSheet);
        sb.append(", enterprise=").append(enterprise);
        sb.append(", hospital_name='").append(hospital_name).append('\'');
        sb.append(", units=").append(units);
        sb.append(", resultStr='").append(resultStr).append('\'');
        sb.append(", startTimeStr='").append(startTimeStr).append('\'');
        sb.append(", overTimeStr='").append(overTimeStr).append('\'');
        sb.append(", activateTimeStr='").append(activateTimeStr).append('\'');
        sb.append(", submitTimeStr='").append(submitTimeStr).append('\'');
        sb.append(", assessorTimeStr='").append(assessorTimeStr).append('\'');
        sb.append(", descripIdStr='").append(descripIdStr).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public DrugInformationSheet getDrugInformationSheet() {
        return drugInformationSheet;
    }

    public void setDrugInformationSheet(DrugInformationSheet drugInformationSheet) {
        this.drugInformationSheet = drugInformationSheet;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
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