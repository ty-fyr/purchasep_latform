package com.hospital.purchase.service;

import com.hospital.purchase.domain.*;
import com.hospital.purchase.domain.dto.SelectDto;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: purchasep_latform
 * @Package: com.hospital.purchase.service
 * @ClassName: JizedongService
 * @Author: 85235
 * @Description: ${description}
 * @Date: 2019/12/30 16:25
 * @Version: 1.0
 */
public interface JizedongService {

    //查询全部
    List<DrugInformationSheet> selecetDrugInformationSheet();

    //查询全部药品信息
    List<DrugInformationSheet> selecetDrugInformationSheet1();

    //条件查询
    List<DrugInformationSheet> findSerchBean(SelectDto selectDto);

    //查询全部质量层次
    List<QualityLevel> findQualityLevel();

    //查询全部药品类别
    List<DrugCategory> findDrugCategory();

    //查询全部供货商
    List<Supplier> findSupplier();

    //通过id查询单条药品信息
    DrugInformationSheet selecetDrugInformationSheetById(Integer drugId);

    //修改药品维护信息
    void updateInfo(SelectDto selectDto);

    //批量提供供货
    void updateBatch(String ids);

    //批量取消供货
    void updaBatch(String ids);

    //查询采购单
    List<Purchase> PurchaseOrderManagement();

    //条件查询
    List<Purchase> findSerchBean3(SelectDto selectDto);

    //通过名字查询单位
    Units selectUnits(String units);

    //根据名字查询生产商
    Enterprise selectEnterprise(String enterprise);

    //导入采购单信息
    void addPurchase(Purchase purchase);

    //查询医院
    Hospital selectHospital(String hospitalName);

    //新增药品
    void addDrugInformationSheet(DrugInformationSheet drugInformationSheet);
}
