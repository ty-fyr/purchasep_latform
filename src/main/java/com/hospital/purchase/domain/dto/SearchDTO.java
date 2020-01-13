package com.hospital.purchase.domain.dto;

import java.util.Date;

public class SearchDTO {
    //采购单编号
    private Integer  purchaseNumber;
    //采购单名称
    private String purchaseName;
    //采购医院名称
    private String hospitalName;
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
    private String startTimeStr;//开始采购时间字符串
    private String overTimeStr;//结束采购时间字符串
    private String activateTimeStr;//建单采购时间字符串
    private String submitTimeStr;//提交采购时间字符串
    private String assessorTimeStr;//审核采购时间字符串
    private String descripIdStr;//采购单状态字符串
    private Integer supplierId;//供货商Id
    private String supplierName;//供货商名称
    //订货数量
    private Integer orderQuantity;
    //订货金额
    private Long orderAmount;
    //送货量
    private Integer deliveryVolume;
    //送货金额
    private Long deliveryAmount;
    //药品流水号
    private Integer drugSerialNumber;
    //通用名
    private String genericDrug;
    //规格
    private String specification;
    //单位
    private String units;
    //商品名
    private String tradeName;
    //生产企业
    private String enterpriseName;

    public Integer getDrugSerialNumber() {
        return drugSerialNumber;
    }

    public void setDrugSerialNumber(Integer drugSerialNumber) {
        this.drugSerialNumber = drugSerialNumber;
    }

    public String getGenericDrug() {
        return genericDrug;
    }

    public void setGenericDrug(String genericDrug) {
        this.genericDrug = genericDrug;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getDeliveryVolume() {
        return deliveryVolume;
    }

    public void setDeliveryVolume(Integer deliveryVolume) {
        this.deliveryVolume = deliveryVolume;
    }

    public Long getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Long deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
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
        this.supplierName = supplierName;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchDTO{");
        sb.append("purchaseNumber=").append(purchaseNumber);
        sb.append(", purchaseName='").append(purchaseName).append('\'');
        sb.append(", hospitalName='").append(hospitalName).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
