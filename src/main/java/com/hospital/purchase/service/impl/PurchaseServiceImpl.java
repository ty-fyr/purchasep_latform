package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

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

    //按采购单查询
    @Override
    public List<Purchase> selectBySearchBean(SearchDTO searchDto) {
        return purchaseMapper.selectBySearchBean(searchDto);
    }
}
