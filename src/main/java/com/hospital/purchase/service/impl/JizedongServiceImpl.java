package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.QualityLevel;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SelectDto;
import com.hospital.purchase.mapper.*;
import com.hospital.purchase.mapper.DrugCategoryMapper;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import com.hospital.purchase.mapper.QualityLevelMapper;
import com.hospital.purchase.service.JizedongService;
import com.hospital.purchase.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: purchasep_latform
 * @Package: com.hospital.purchase.service.impl
 * @ClassName: JizedongServiceImpl
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2019/12/30 16:25
 * @Version: 1.0
 */
@Service
public class JizedongServiceImpl implements JizedongService {

    @Autowired
    private DrugInformationSheetMapper drugInformationSheetMapper;

    @Autowired
    private QualityLevelMapper qualityLevelMapper;

    @Autowired
    private DrugCategoryMapper drugCategoryMapper;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierManagementMapper supplierManagementMapper;

    //查询全部
    @Override
    public List<DrugInformationSheet> selecetDrugInformationSheet() {
        return drugInformationSheetMapper.selecetDrugInformationSheet();
    }

    @Override
    public List<DrugInformationSheet> selecetDrugInformationSheet1() {
        return drugInformationSheetMapper.selecetDrugInformationSheet1();
    }

    //条件查询
    @Override
    public List<DrugInformationSheet> findSerchBean(SelectDto selectDto) {
        return drugInformationSheetMapper.findSerchBean(selectDto);
    }

    //查询全部质量层次
    @Override
    public List<QualityLevel> findQualityLevel() {
        return qualityLevelMapper.findQualityLevel();
    }

    //查询全部药品层次
    @Override
    public List<DrugCategory> findDrugCategory() {
        return drugCategoryMapper.findDrugCategory();
    }

    //查询全部供货商
    @Override
    public List<Supplier> findSupplier() {
        return supplierMapper.findSupplier();
    }

    @Override
    public DrugInformationSheet selecetDrugInformationSheetById(Integer drugId) {
        DrugInformationSheet drugInformationSheet = drugInformationSheetMapper.selecetDrugInformationSheetById(drugId);
       drugInformationSheet.setApprovalNumberDateStr(DateUtils.dateFormat(drugInformationSheet.getApprovalNumberDate(),"yyyy-MM-dd"));
       drugInformationSheet.setDrugInspectionReportStr(DateUtils.dateFormat(drugInformationSheet.getDrugInspectionReport(),"yyyy-MM-dd"));
        return drugInformationSheet;
    }

    @Override
    public void updateInfo(SelectDto selectDto) {
        selectDto.setApprovalNumberDate(DateUtils.dateParse(selectDto.getApprovalNumberDateStr(),"yyyy-MM-dd"));
        selectDto.setDrugInspectionReport(DateUtils.dateParse(selectDto.getDrugInspectionReportStr(),"yyyy-MM-dd"));
        drugInformationSheetMapper.updateInfo(selectDto);
    }

    @Override
    public void updateBatch(String ids) {
        String[] split = ids.split(",");
        for (String drugId:split){
            supplierManagementMapper.updateBatch(Integer.parseInt(drugId));
        }
    }

    @Override
    public void updaBatch(String ids) {
        String[] split = ids.split(",");
        for (String drugId:split){
            supplierManagementMapper.updaBatch(Integer.parseInt(drugId));
        }
    }
}
