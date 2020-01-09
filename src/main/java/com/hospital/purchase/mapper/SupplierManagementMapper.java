package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.SupplierManagement;

public interface SupplierManagementMapper {
    int deleteByPrimaryKey(Integer supplyId);

    int insert(SupplierManagement record);

    int insertSelective(SupplierManagement record);

    SupplierManagement selectByPrimaryKey(Integer supplyId);

    int updateByPrimaryKeySelective(SupplierManagement record);

    int updateByPrimaryKey(SupplierManagement record);

    //批量提供供货
    void updateBatch(Integer drugId);

    //批量取消供货
    void updaBatch(Integer drugId);
}