package com.hospital.purchase.domain.dto;

import java.util.Date;

/**
 * @ProjectName: purchasep_latform
 * @Package: com.hospital.purchase.domain.dto
 * @ClassName: SelectDto
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2020/1/2 15:22
 * @Version: 1.0
 */
public class SelectDto {

    private Integer drugSerialNumber;
    private String genericDrug;
    private String dosageForm;
    private String specification;
    private String units;
    private Integer conversionFactor;
    private Integer enterpriseId;
    private String tradeName;
    private Float minMoney;
    private Float maxMoney;
    private Integer leveId;
    private Integer dcId;
    private Integer descripId;
    private Integer supplierId;

    private Integer result;



    private Integer drugId;
    private Float thePrice;
    private Integer approvalNumber;
    private String approvalNumberDateStr;
    private Integer whetherImport;
    private String packaging;
    private String packingUnit;
    private Float latestRetailPrice;
    private String SourcePrice;
    private String qualityHierarchy;
    private Integer inspectionReport;
    private Integer drugInspection;
    private String drugInspectionReportStr;
    private String description;

    private String enterpriseName;

    private Date approvalNumberDate;
    private Date drugInspectionReport;


    private Integer PurchaseNumber;
    private String PurchaseName;
    private String hospitalName;
    private String startTime;
    private String overTime;

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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Date getApprovalNumberDate() {
        return approvalNumberDate;
    }

    public void setApprovalNumberDate(Date approvalNumberDate) {
        this.approvalNumberDate = approvalNumberDate;
    }

    public Date getDrugInspectionReport() {
        return drugInspectionReport;
    }

    public void setDrugInspectionReport(Date drugInspectionReport) {
        this.drugInspectionReport = drugInspectionReport;
    }

    public Float getThePrice() {
        return thePrice;
    }

    public void setThePrice(Float thePrice) {
        this.thePrice = thePrice;
    }

    public Integer getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(Integer approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getApprovalNumberDateStr() {
        return approvalNumberDateStr;
    }

    public void setApprovalNumberDateStr(String approvalNumberDateStr) {
        this.approvalNumberDateStr = approvalNumberDateStr;
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

    public Float getLatestRetailPrice() {
        return latestRetailPrice;
    }

    public void setLatestRetailPrice(Float latestRetailPrice) {
        this.latestRetailPrice = latestRetailPrice;
    }

    public String getSourcePrice() {
        return SourcePrice;
    }

    public void setSourcePrice(String sourcePrice) {
        SourcePrice = sourcePrice;
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

    public String getDrugInspectionReportStr() {
        return drugInspectionReportStr;
    }

    public void setDrugInspectionReportStr(String drugInspectionReportStr) {
        this.drugInspectionReportStr = drugInspectionReportStr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

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

    public Float getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Float minMoney) {
        this.minMoney = minMoney;
    }

    public Float getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Float maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Integer getLeveId() {
        return leveId;
    }

    public void setLeveId(Integer leveId) {
        this.leveId = leveId;
    }

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public Integer getDescripId() {
        return descripId;
    }

    public void setDescripId(Integer descripId) {
        this.descripId = descripId;
    }
}
