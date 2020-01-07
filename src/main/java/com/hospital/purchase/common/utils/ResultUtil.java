package com.hospital.purchase.common.utils;

import com.google.common.collect.ImmutableMap;
import com.hospital.purchase.common.enums.ErrorEnum;
import com.hospital.purchase.common.model.ResultBean;

import java.util.Map;

public final class ResultUtil {
    public static ResultBean buildErrorResult(ErrorEnum errorEnum) {
        ResultBean resultBean = new ResultBean();
        resultBean.setErrType(errorEnum.getErrType());
        resultBean.setErrCode(errorEnum.getErrCode());
        resultBean.setErrMsg(errorEnum.getErrMsg());
        return resultBean;
    }

    public static ResultBean buildSuccessResult(Map<String,Object> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setErrType(ErrorEnum.SUCCESS.getErrType());
        resultBean.setErrCode(ErrorEnum.SUCCESS.getErrCode());
        resultBean.setErrMsg(ErrorEnum.SUCCESS.getErrMsg());
        resultBean.setData(data);
        return resultBean;
    }
    public static ResultBean buildSuccessResult(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setErrType(ErrorEnum.SUCCESS.getErrType());
        resultBean.setErrCode(ErrorEnum.SUCCESS.getErrCode());
        resultBean.setErrMsg(ErrorEnum.SUCCESS.getErrMsg());
        resultBean.setData(ImmutableMap.of("data",data));
        return resultBean;
    }
}
