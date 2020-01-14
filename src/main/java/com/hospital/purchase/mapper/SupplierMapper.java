package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.Supplier;

import java.util.List;

/**
 * song 供货审核
 */
public interface SupplierMapper {

    List<DrugInformationSheet> findAll();



    //查询全部供货商
    List<Supplier> findSupplier();
}