package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer piId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer piId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    /*
     * 按采购单查询
     */
    Purchase selectByPrimaryKey(String purchaseName);

}