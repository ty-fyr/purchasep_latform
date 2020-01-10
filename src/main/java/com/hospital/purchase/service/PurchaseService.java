package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;
import org.apache.ibatis.annotations.Param;

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
    /**
     * 采购表查询全部
     *
     */
    List<Purchase> findAll();

    /**
     * 采购表提交审核结果
     */
    int update(@Param("piId") Integer piId, @Param("purchase") Purchase purchase);
}
