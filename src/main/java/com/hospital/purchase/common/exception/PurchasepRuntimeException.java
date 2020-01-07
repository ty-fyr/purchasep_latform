package com.hospital.purchase.common.exception;

import com.hospital.purchase.common.enums.ErrorEnum;

public class PurchasepRuntimeException extends  RuntimeException{

    private static final long serialVersionUID = -1519394266719643114L;
    private ErrorEnum errorEnum;

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public PurchasepRuntimeException(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
