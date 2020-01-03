package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.SupplierSupply;

public interface SupplierSupplyMapper {
    int deleteByPrimaryKey(Integer supplierSupplyId);

    int insert(SupplierSupply record);

    int insertSelective(SupplierSupply record);

    SupplierSupply selectByPrimaryKey(Integer supplierSupplyId);

    int updateByPrimaryKeySelective(SupplierSupply record);

    int updateByPrimaryKey(SupplierSupply record);
}