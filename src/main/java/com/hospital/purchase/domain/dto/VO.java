package com.hospital.purchase.domain.dto;

import java.math.BigDecimal;

public class VO {
    
    //采购单id
    private Integer piId;
    //药品id
    //private Integer drugId;
    //审核结果(0正在审核,1代表未审核)
    private Integer result;
    //意见
    private String opinion;
    //医院id
    private Integer hospitalId;
    //采购单编号
    private Integer PurchaseNumber;
    //采购单名称
    private String PurchaseName;
    //开始时间
    private String startTime;
    //结束时间
    private String overTime;
    //建单时间
    private String activateTime;
    //提交时间
    private String submitTime;
    //审核时间
    private String assessorTime;
    //采购单状态(0已入库，1未入库）
    private Integer descripId;
    //1删除0不删除
    private Integer isdel;
    //审核人
    private String auditor;
    //联系人
    private String contacts;
    //联系人电话
    private String contactsph;
    //供货商id
    //private Integer supplierId;
    //交易id
    //private Integer tiId;
    //库存id
    private Integer repertoryId;

    //交易信息主键
    private Integer tiId;
    //供货状态(1代表供货,0代表断货)
    private Integer supplyStatus;
    //订货数量
    private Integer orderQuantity;
    //订货金额
    private BigDecimal orderAmount;
    //送货量
    private Integer deliveryVolume;
    //送货金额
    private BigDecimal deliveryAmount;
    //退货量
    private Integer returnNumber;
    //退货金额
    private BigDecimal returnAmount;
    //结算量
    private Integer settlementNumber;
    //结算金额
    private BigDecimal settlementAmount;
    //采购单id
    //private Integer piId;
    //0未删除，1删除
    //private Integer isdel;


    //供货商表
    private Integer supplierId;
    //供货商名称
    private String SupplierName;
    //公司注册地址
    private String RegisteredAddress;
    //营业执照
    private String businessLicense;
    //注册时间
    private String RegistrationTime;
    //药品id
    private Integer druginId;

    //医院表
    //private Integer hospitalId;
    //医院名字
    private String hospitalName;
    //医院编号
    private String HospitalNumber;
    //营业执照
    private String businessLicence;
    //注册时间
    private String registrationTime;

    //药品信息ID
    private Integer drugid;
    //药品流水号
    private Integer drugSerialNumber;
    //药品品目号
    private Integer drugItemNo;
    //通用名
    private String genericDrug;
    //剂型
    private String dosageForm;
    //规格
    private String specification;
    //单位
    private String units;
    //转换系数
    private Integer conversionFactor;
    //生产企业ID
    private Integer enterpriseId;
    //商品名称
    private String tradeName;
    //中标价
    private String thePrice;
    //批准文号
    private Integer approvalNumber;
    //批准文号有效期
    private String approvalNumberDate;
    //是否进口(0代表进口,1代表本地)
    private Integer whetherImport;
    //包装材质
    private String packaging;
    //包装单位
    private String packingUnit;
    //最新零售价
    private String latestRetailPrice;
    //零售价出处
    private String SourcePrice;
    //质量层次
    private Integer levelId;
    //质量层次说明
    private String qualityHierarchy;
    //有无药品检验报告(0代表有,1代表无)
    private Integer inspectionReport;
    //药品检验报告编号
    private Integer drugInspection;
    //药品检验报告有效期
    private String drugInspectionReport;
    //药品类别
    private Integer dcId;
    //交易状态(0代表正常,1代表暂停交易)
    //private Integer descrip_id;
    //产品说明
    private String description;
    //是否删除(0代表未删除,1代表删除)
   // private Integer isdel;
    //0为品目查询，1为信息查询，2为都有
    private Integer proxyId;

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
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
        return PurchaseNumber;
    }

    public void setPurchaseNumber(Integer purchaseNumber) {
        PurchaseNumber = purchaseNumber;
    }

    public String getPurchaseName() {
        return PurchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        PurchaseName = purchaseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(String activateTime) {
        this.activateTime = activateTime;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getAssessorTime() {
        return assessorTime;
    }

    public void setAssessorTime(String assessorTime) {
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

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Integer getTiId() {
        return tiId;
    }

    public void setTiId(Integer tiId) {
        this.tiId = tiId;
    }

    public Integer getSupplyStatus() {
        return supplyStatus;
    }

    public void setSupplyStatus(Integer supplyStatus) {
        this.supplyStatus = supplyStatus;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getDeliveryVolume() {
        return deliveryVolume;
    }

    public void setDeliveryVolume(Integer deliveryVolume) {
        this.deliveryVolume = deliveryVolume;
    }

    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getSettlementNumber() {
        return settlementNumber;
    }

    public void setSettlementNumber(Integer settlementNumber) {
        this.settlementNumber = settlementNumber;
    }

    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getRegisteredAddress() {
        return RegisteredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        RegisteredAddress = registeredAddress;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getRegistrationTime() {
        return RegistrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        RegistrationTime = registrationTime;
    }

    public Integer getDrugid() {
        return drugid;
    }

    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }

    public Integer getDrugSerialNumber() {
        return drugSerialNumber;
    }

    public void setDrugSerialNumber(Integer drugSerialNumber) {
        this.drugSerialNumber = drugSerialNumber;
    }

    public Integer getDrugItemNo() {
        return drugItemNo;
    }

    public void setDrugItemNo(Integer drugItemNo) {
        this.drugItemNo = drugItemNo;
    }

    public String getGenericDrug() {
        return genericDrug;
    }

    public void setGenericDrug(String genericDrug) {
        this.genericDrug = genericDrug;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
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

    public Integer getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Integer conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getThePrice() {
        return thePrice;
    }

    public void setThePrice(String thePrice) {
        this.thePrice = thePrice;
    }

    public Integer getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(Integer approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getApprovalNumberDate() {
        return approvalNumberDate;
    }

    public void setApprovalNumberDate(String approvalNumberDate) {
        this.approvalNumberDate = approvalNumberDate;
    }

    public Integer getWhetherImport() {
        return whetherImport;
    }

    public void setWhetherImport(Integer whetherImport) {
        this.whetherImport = whetherImport;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public String getLatestRetailPrice() {
        return latestRetailPrice;
    }

    public void setLatestRetailPrice(String latestRetailPrice) {
        this.latestRetailPrice = latestRetailPrice;
    }

    public String getSourcePrice() {
        return SourcePrice;
    }

    public void setSourcePrice(String sourcePrice) {
        SourcePrice = sourcePrice;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getQualityHierarchy() {
        return qualityHierarchy;
    }

    public void setQualityHierarchy(String qualityHierarchy) {
        this.qualityHierarchy = qualityHierarchy;
    }

    public Integer getInspectionReport() {
        return inspectionReport;
    }

    public void setInspectionReport(Integer inspectionReport) {
        this.inspectionReport = inspectionReport;
    }

    public Integer getDrugInspection() {
        return drugInspection;
    }

    public void setDrugInspection(Integer drugInspection) {
        this.drugInspection = drugInspection;
    }

    public String getDrugInspectionReport() {
        return drugInspectionReport;
    }

    public void setDrugInspectionReport(String drugInspectionReport) {
        this.drugInspectionReport = drugInspectionReport;
    }

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }

    public Integer getDruginId() {
        return druginId;
    }

    public void setDruginId(Integer druginId) {
        this.druginId = druginId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalNumber() {
        return HospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        HospitalNumber = hospitalNumber;
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
    }
}
