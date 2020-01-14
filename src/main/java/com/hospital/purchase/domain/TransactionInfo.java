package com.hospital.purchase.domain;

public class TransactionInfo {
    //交易信息主键
    private Integer tiId;
    //供货状态(1代表供货,0代表断货)
    private Integer supplyStatus;
    //订货数量
    private Integer orderQuantity;
    //订货金额
    private Long orderAmount;
    //送货量
    private Integer deliveryVolume;
    //送货金额
    private Long deliveryAmount;
    //退货量
    private Integer returnNumber;
    //退货金额
    private Long returnAmount;
    //结算量
    private Integer settlementNumber;
    //结算金额
    private Long settlementAmount;
    //采购单id
    private Integer piId;
    //isdel
    private Integer isdel;





    public Long getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Long returnAmount) {
        this.returnAmount = returnAmount;
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

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public Integer getSettlementNumber() {
        return settlementNumber;
    }

    public void setSettlementNumber(Integer settlementNumber) {
        this.settlementNumber = settlementNumber;
    }

    public Long getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(Long settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}