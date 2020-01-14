package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.mapper.HospitalMapper;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.mapper.SupplierMapper;
import com.hospital.purchase.service.ZjqService;
import com.hospital.purchase.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZjqServiceImpl implements ZjqService {

    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    HospitalMapper hospitalMapper;

    /**
     * 按采购单查询
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryCGD() {
        return  purchaseMapper.selectByPrimaryCGD();
    }

    /**
     * 按供货商查询
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryGHS() {
        return purchaseMapper.selectByPrimaryGHS();
    }

    /**
     * 按供货商查询
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryYY() {
        return purchaseMapper.selectByPrimaryYY();
    }

    /**
     * 按交易药品查询
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryJYYP() {
        return  purchaseMapper.selectByPrimaryJYYP();
    }

    /**
     * 查询药品交易明细
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryJYMX() {
        return purchaseMapper.selectByPrimaryJYMX();
    }

    /**
     * 模糊查询采购单
     * @param purchase
     * @return
     */
    @Override
    public List<Purchase> selectByPrimaryMHCX(SearchDTO searchDTO) {
        return purchaseMapper.selectByPrimaryMHCX(searchDTO);
    }

    /**
     * 按供应商模糊查询
     * @param searchDTO
     * @return
     */
    @Override
    public List<Purchase> selectSupplierMHCX(SearchDTO searchDTO) {
        return purchaseMapper.selectSupplierMHCX(searchDTO);
    }

    /**
     * 按医院模糊查询
     * @param searchDTO
     * @return
     */
    @Override
    public List<Purchase> selectHospitalMHCX(SearchDTO searchDTO) {
        return purchaseMapper.selectHospitalMHCX(searchDTO);
    }


}
