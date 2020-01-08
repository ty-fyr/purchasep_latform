package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseService {

    //查询全部
    List<Purchase> selectAll();//
    //动态查询
    List<Purchase> selectBySearchBean(SearchDTO searchDto);

         /*
          * 采购表查询
          *
          */
   List<Purchase> seleLike(Map<String,Object> map);
}
