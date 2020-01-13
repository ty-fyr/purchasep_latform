package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.domain.dto.SelectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

@Mapper
public interface PurchaseMapper {

    //张 按采购单查询
    List<Purchase> selectByPrimaryCGD ();
    //张  按供货商查询
    List<Purchase> selectByPrimaryGHS();
    //张  按医院查询
    List<Purchase> selectByPrimaryYY();
    //张  按交易药品查询
    List<Purchase> selectByPrimaryJYYY();
    //张 模糊查询
    List<Purchase> selectByPrimaryMHCX (SearchDTO searchDTO);



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
    //按采购医院搜索
    List<Purchase> searchHospital(SearchDTO searchDTO);
    /*
     * 按采购单查询
     */
    Purchase selectByPrimaryKey(String purchaseName);

    /*
    * 采购表查询
    * */
    List<Purchase> seleLike(Map<String,Object> map);

    /**
     *   按交易药品查询
     * @return yao
     */
    List<Purchase> selectTradingDrugs();

    /**
     * 交易药品搜索
     * @return
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


    //查询采购单
    List<Purchase> PurchaseOrderManagement();

    //条件查询
    List<Purchase> findSerchBean3(SelectDto selectDto);

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