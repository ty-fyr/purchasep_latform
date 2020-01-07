package com.hospital.purchase.service;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.QualityLevel;
import com.hospital.purchase.domain.Supplier;
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

 */
public interface JizedongService {

    //查询全部
    List<DrugInformationSheet> selecetDrugInformationSheet();

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
}
