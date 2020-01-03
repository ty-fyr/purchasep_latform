package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.DrugCategory;

import org.apache.ibatis.annotations.Mapper;


public interface DrugCategoryMapper {
    int deleteByPrimaryKey(Integer dcId);

    int insert(DrugCategory record);

    int insertSelective(DrugCategory record);

    DrugCategory selectByPrimaryKey(Integer dcId);

    int updateByPrimaryKeySelective(DrugCategory record);

    int updateByPrimaryKey(DrugCategory record);
}