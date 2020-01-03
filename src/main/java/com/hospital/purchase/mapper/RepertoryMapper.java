package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Repertory;

public interface RepertoryMapper {
    int deleteByPrimaryKey(Integer repertoryId);

    int insert(Repertory record);

    int insertSelective(Repertory record);

    Repertory selectByPrimaryKey(Integer repertoryId);

    int updateByPrimaryKeySelective(Repertory record);

    int updateByPrimaryKey(Repertory record);
}