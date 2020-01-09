package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.mapper.SupplierMapper;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private SupplierMapper supplierMapper;
    /**
     *  查询所有
     *
     * @return
     */
    @Override
    public List<Purchase> selectAll() {
        List<Purchase> purchaseList = purchaseMapper.selectAll();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 按采购单查询
     * @param searchDto
     * @return List<Purchase> 采购单集合
     */
    @Override
    public List<Purchase> selectBySearchBean(SearchDTO searchDto) {
        List<Purchase> purchaseList = purchaseMapper.selectBySearchBean(searchDto);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 查询全部供货商信息
     * @return 供货商信息
     */
    @Override
    public List<Purchase> selectAllSupplier() {
        List<Purchase> purchaseList = purchaseMapper.selectAllSupplier();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    @Override
    public List<Supplier> findSupplier() {
        return supplierMapper.findSupplier();
    }

    /**
     * 按供货商搜索
     * @param searchDTO
     * @return 供货商
     */
    @Override
    public List<Purchase> selectBySupplier(SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseMapper.selectBySupplier(searchDTO);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    @Override
    public List<Purchase> selectAllHospital() {
        List<Purchase> purchaseList = purchaseMapper.selectAllHospital();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    @Override
    public List<Purchase> seleLike(Map<String, Object> map) {
        return purchaseMapper.seleLike(map);
    }
}
