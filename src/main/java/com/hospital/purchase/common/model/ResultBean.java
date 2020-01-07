package com.hospital.purchase.common.model;


import java.io.Serializable;
import java.util.Map;

public class ResultBean implements Serializable {
    private static final long serialVersionUID = -7812816605385746696L;
    /**
     * 错误类型
     * <li>0 成功</li>
     * <li>1 系统异常</li>
     * <li>2 业务异常</li>
     */
    private short errType;
    /**
     * 错误码
     * 10 位   2位错误类型 +  8 错误xxx
     * 0100000001
     * 0100000002
     * 0100000008
     *
     * 01234234233
     *
     * 021000000001
     * 021000000005
     * 021000000007
     */
    private String errCode;
    private String errMsg;
    private Map<String,Object> data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public short getErrType() {
        return errType;
    }

    public void setErrType(short errType) {
        this.errType = errType;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
