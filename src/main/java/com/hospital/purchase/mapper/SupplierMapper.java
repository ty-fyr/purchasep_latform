package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Supplier;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> findSupplier();
}