package com.hospital.purchase.domain.dto;

public class SearchDTO {
    //采购单编号
    private Integer  purchaseNumber;
    //采购单名称
    private String purchaseName;
    //采购医院名称
    private String hospitalName;

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
