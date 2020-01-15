package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Units;

public interface UnitsMapper {
    int deleteByPrimaryKey(Integer unitsId);

    int insert(Units record);

    int insertSelective(Units record);

    Units selectByPrimaryKey(Integer unitsId);

    int updateByPrimaryKeySelective(Units record);

    int updateByPrimaryKey(Units record);

    //通过名字查询单位
    Units selectUnits(String units);
}