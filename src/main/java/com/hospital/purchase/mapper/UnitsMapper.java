package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Units;

public interface UnitsMapper {
    int deleteByPrimaryKey(Integer unitsId);

    int insert(Units record);

    int insertSelective(Units record);

    Units selectByPrimaryKey(Integer unitsId);

    int updateByPrimaryKeySelective(Units record);

    int updateByPrimaryKey(Units record);
}