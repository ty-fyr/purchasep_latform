package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDto;

import java.util.List;

public interface PurchaseService {
    //查询全部
    List<Purchase> selectAll();
    //动态查询
    List<Purchase> selectBySearchBean(SearchDto searchDto);
}
