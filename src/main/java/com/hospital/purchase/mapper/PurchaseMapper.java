package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseMapper {
    /*
     * 按采购单查询
     */
    List<Purchase> selectByPrimaryName ();
    /*
    模糊查询
     */
    List<Purchase> selectByMHCX (Purchase purchase);



    //查询全部
    List<Purchase> selectAll();

    //动态查询
    List<Purchase> selectBySearchBean(SearchDTO searchDto);
    /*
     * 按采购单查询
     */
    Purchase selectByPrimaryKey(String purchaseName);

    /*
    * 采购表查询
    * */
    List<Purchase> seleLike(Map<String,Object> map);
}