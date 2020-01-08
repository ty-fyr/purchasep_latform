package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.service.ZjqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZjqServiceImpl implements ZjqService {

    @Autowired
    PurchaseMapper Mapper;
//

    @Override
    public List<Purchase> selectByPrimaryName() {
        List<Purchase> purchases = Mapper.selectByPrimaryName();
        return purchases;
    }
}
