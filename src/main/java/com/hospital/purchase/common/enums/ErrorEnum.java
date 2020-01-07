package com.hospital.purchase.common.enums;

import com.hospital.purchase.common.constants.ErrTypeConstant;

public enum ErrorEnum {
    SUCCESS(ErrTypeConstant.SUCCESS, "0", "成功"),
    QUERY_EXCEPTION(ErrTypeConstant.BUSINESS_ERROR, ErrTypeConstant.BUSINESS_ERROR+"00000888", "没库存了"),
    SYSTEM_ERROR(ErrTypeConstant.SYSTEM_ERROR, ErrTypeConstant.SYSTEM_ERROR + "00000099", "系统异常");

    ErrorEnum(short errType, String errCode, String errMsg) {
        this.errType = errType;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public short getErrType() {
        return errType;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    private short errType;
    private String errCode;
    private String errMsg;
}
