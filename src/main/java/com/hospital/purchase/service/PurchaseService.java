package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;

import java.util.List;
import java.util.Map;

public interface PurchaseService {
    //查询全部
    List<Purchase> selectAll();
    //动态查询
    List<Purchase> selectBySearchBean(SearchDTO searchDto);
    //查询全部供货商信息
    List<Purchase> selectAllSupplier();
    //查询全部供货商名称
    List<Supplier> findSupplier();
    //安供货商查询
    List<Purchase> selectBySupplier(SearchDTO searchDTO);

    //查询全部采购医院信息
    List<Purchase> selectAllHospital();
    /*
     * 采购表查询
     *
     */
    List<Purchase> seleLike(Map<String,Object> map);
}
