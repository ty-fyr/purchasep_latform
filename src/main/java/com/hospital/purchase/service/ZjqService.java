package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;

import java.util.List;

public interface ZjqService {
    //
    /*
     * 按采购单查询
     */
    List<Purchase> selectByPrimaryName();
}
