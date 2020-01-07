package com.hospital.purchase.domain;

import com.hospital.purchase.common.utils.DateUtils;
import lombok.*;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    private Hospital hospital;
    private TransactionInfo transactionInfo;

    //医院名称
    private String hospital_name;

    private String startTimeStr;//开始采购时间字符串
    private String overTimeStr;//结束采购时间字符串
    private String activateTimeStr;//建单采购时间字符串
    private String submitTimeStr;//提交采购时间字符串
    private String assessorTimeStr;//审核采购时间字符串
    private String descripIdStr;//采购单状态字符串

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
        if (Objects.equals(this.getDescripId(),0)) {
            this.setDescripIdStr("已入库");
        } else if (Objects.equals(this.getDescripId(),1)) {
            this.setDescripIdStr("未入库");
        }
    }


}