package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.QualityLevel;

import java.util.List;

public interface QualityLevelMapper {

    //查询全部质量层次
    List<QualityLevel> findQualityLevel();
}