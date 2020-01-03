package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Middle;

public interface MiddleMapper {
    int deleteByPrimaryKey(Integer centralId);

    int insert(Middle record);

    int insertSelective(Middle record);

    Middle selectByPrimaryKey(Integer centralId);

    int updateByPrimaryKeySelective(Middle record);

    int updateByPrimaryKey(Middle record);
}