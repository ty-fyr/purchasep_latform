package com.hospital.purchase.service;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import org.apache.ibatis.annotations.Param;

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
    //安供货商搜索
    List<Purchase> selectBySupplier(SearchDTO searchDTO);

    //查询全部采购医院信息
    List<Purchase> selectAllHospital();

    //按采购医院搜索
    List<Purchase> searchHospital(SearchDTO searchDTO);
    /**
     *   按交易药品查询
     * @return k
     */
    List<Purchase> selectTradingDrugs();

    /**
     * 交易药品搜索
     * @return yaopin
     */
    List<Purchase> searchBuyDrug(SearchDTO searchDTO);

    /**
     * 查询药品详情明细
     * @return 药品采购明细
     */
    List<Purchase> queryDrugInfo();

    /**
     *采购药品信息搜索
     * @param searchDTO
     * @return yp info
     */
    List<Purchase> searchDrugInfo(SearchDTO searchDTO);
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
