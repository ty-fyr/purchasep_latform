package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.TransactionInfo;

public interface TransactionInfoMapper {
    int deleteByPrimaryKey(Integer tiId);

    int insert(TransactionInfo record);

    int insertSelective(TransactionInfo record);

    TransactionInfo selectByPrimaryKey(Integer tiId);

    int updateByPrimaryKeySelective(TransactionInfo record);

    int updateByPrimaryKey(TransactionInfo record);
}