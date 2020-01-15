package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.*;
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

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private UnitsMapper unitsMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private HospitalMapper hospitalMapper;

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

    @Override
    public List<Purchase> PurchaseOrderManagement() {
        List<Purchase> purchases = purchaseMapper.PurchaseOrderManagement();
        for (int i = 0; i <purchases.size() ; i++) {
            purchases.get(i).setStartTimeStr(DateUtils.dateFormat(purchases.get(i).getStartTime(),"yyyy-MM-dd"));
            purchases.get(i).setOverTimeStr(DateUtils.dateFormat(purchases.get(i).getOverTime(),"yyyy-MM-dd"));
        }
        return purchases;
    }

    @Override
    public List<Purchase> findSerchBean3(SelectDto selectDto) {
        List<Purchase> serchBean3 = purchaseMapper.findSerchBean3(selectDto);
        for (int i = 0; i <serchBean3.size() ; i++) {
            serchBean3.get(i).setStartTimeStr(DateUtils.dateFormat(serchBean3.get(i).getStartTime(),"yyyy-MM-dd"));
            serchBean3.get(i).setOverTimeStr(DateUtils.dateFormat(serchBean3.get(i).getOverTime(),"yyyy-MM-dd"));
        }
        return serchBean3;
    }

    @Override
    public Units selectUnits(String units) {
        return unitsMapper.selectUnits(units);
    }

    @Override
    public Enterprise selectEnterprise(String enterprise) {
        return enterpriseMapper.selectEnterprise(enterprise);
    }

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseMapper.addPurchase(purchase);
    }

    @Override
    public Hospital selectHospital(String hospitalName) {
        return hospitalMapper.selectHospital(hospitalName);
    }

    @Override
    public void addDrugInformationSheet(DrugInformationSheet drugInformationSheet) {
        drugInformationSheetMapper.addDrugInformationSheet(drugInformationSheet);
    }
}
