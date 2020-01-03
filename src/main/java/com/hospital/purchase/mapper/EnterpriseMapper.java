package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Enterprise;

public interface EnterpriseMapper {
    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer enterpriseId);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}