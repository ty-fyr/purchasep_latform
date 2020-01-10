package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.domain.dto.VO;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import com.hospital.purchase.mapper.HospitalMapper;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.mapper.SupplierMapper;
import com.hospital.purchase.service.ZjqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZjqServiceImpl implements ZjqService {

    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    SupplierMapper supplierMapper;

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
    public List<Purchase> selectByPrimaryJYYY() {
        return  purchaseMapper.selectByPrimaryJYYY();
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

    @Override
    public List<Supplier> selectSupplierMHCX(VO vo) {
        return supplierMapper.selectSupplierMHCX(vo);
    }
}
