package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.QualityLevel;

public interface QualityLevelMapper {
    int deleteByPrimaryKey(Integer levelId);

    int insert(QualityLevel record);

    int insertSelective(QualityLevel record);

    QualityLevel selectByPrimaryKey(Integer levelId);

    int updateByPrimaryKeySelective(QualityLevel record);

    int updateByPrimaryKey(QualityLevel record);
}