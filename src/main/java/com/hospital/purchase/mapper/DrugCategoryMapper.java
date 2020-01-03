package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.DrugCategory;

import java.util.List;

public interface DrugCategoryMapper {

    //查询全部药品类别
    List<DrugCategory> findDrugCategory();
}