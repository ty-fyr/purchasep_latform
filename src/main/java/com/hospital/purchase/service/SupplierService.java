package com.hospital.purchase.service;

import com.hospital.purchase.domain.DrugInformationSheet;

import java.util.List;
/**
 * song 供货审核
 */
public interface SupplierService {
    List<DrugInformationSheet> findAll();
}
