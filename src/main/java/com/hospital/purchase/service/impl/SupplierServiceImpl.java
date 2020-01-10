package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.mapper.SupplierMapper;
import com.hospital.purchase.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * song 供货审核
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<DrugInformationSheet> findAll() {
        List<DrugInformationSheet> all = supplierMapper.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getDescripId().equals(0)){
                all.get(i).setDescripIdStr("正常");
            }else {
                all.get(i).setDescripIdStr("暂停交易");
            }
        }
        return all;
    }
}
