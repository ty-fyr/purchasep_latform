package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;



import java.util.List;
import java.util.Map;

@Mapper
public interface PurchaseMapper {
    //
	/*
     * 按采购单查询
     */
    List<Purchase> selectByPrimaryName ();
    /*
    模糊查询
     */
    List<Purchase> selectByMHCX (Purchase purchase);



    //查询全部采购信息
    List<Purchase> selectAll();

    //动态查询
    List<Purchase> selectBySearchBean(SearchDTO searchDto);

    //查询全部供货商信息
    List<Purchase> selectAllSupplier();

    //安供货商搜索
    List<Purchase> selectBySupplier(SearchDTO searchDTO);

    //查询全部采购医院信息
    List<Purchase> selectAllHospital();
    /*
     * 按采购单查询
     */
    Purchase selectByPrimaryKey(String purchaseName);

    /*
    * 采购表查询
    * */
    List<Purchase> seleLike(Map<String,Object> map);
}