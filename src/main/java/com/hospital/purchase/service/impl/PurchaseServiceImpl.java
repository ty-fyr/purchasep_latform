package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.mapper.SupplierMapper;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Purchase> selectAll() {
        List<Purchase> purchaseList = purchaseMapper.selectAll();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 按采购单查询
     *
     * @param searchDto
     * @return List<Purchase> 采购单集合
     */
    @Override
    public List<Purchase> selectBySearchBean(SearchDTO searchDto) {
        List<Purchase> purchaseList = purchaseMapper.selectBySearchBean(searchDto);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 查询全部供货商信息
     *
     * @return 供货商信息
     */
    @Override
    public List<Purchase> selectAllSupplier() {
        List<Purchase> purchaseList = purchaseMapper.selectAllSupplier();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }


    @Override
    public List<Supplier> findSupplier() {
        return supplierMapper.findSupplier();
    }

    /**
     * 按供货商搜索
     * @param searchDTO
     * @return 供货商
     */
    @Override
    public List<Purchase> selectBySupplier(SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseMapper.selectBySupplier(searchDTO);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /*
     * 采购表查询
     *
     */
    @Override
    public List<Purchase> seleLike(Map<String, Object> map) {
        List<Purchase> list = purchaseMapper.seleLike(map);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getResult().equals(0)) {
                list.get(i).setResultStr("审核通过");
            } else {
                list.get(i).setResultStr("未通过");
            }
        }
        return list;
    }

    /**
     * 采购表查询全部
     */
    @Override
    public List<Purchase> findAll() {
        List<Purchase> list2 = purchaseMapper.findAll();
        for (int j = 0; j < list2.size(); j++) {
//            if (list2.get(j).getResult().equals(0)){
//                list2.get(j).setResultStr("审核通过");
//            }else {
//                list2.get(j).setResultStr("未通过");
//            }
        }
        return list2;
    }

    @Override
    public int update(Integer piId, Purchase purchase) {
        return purchaseMapper.update(piId, purchase);
    }

    /**
     * 查询所有采购医院信息列表
     *
     * @return info
     */
    @Override
    public List<Purchase> selectAllHospital() {
        List<Purchase> purchaseList = purchaseMapper.selectAllHospital();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;

    }

    /**
     * //按采购医院搜索
     *
     * @param searchDTO
     * @return kdmk
     */
    @Override
    public List<Purchase> searchHospital(SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseMapper.searchHospital(searchDTO);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 查询交易药品列表
     *
     * @return mmlk
     */
    @Override
    public List<Purchase> selectTradingDrugs() {
        List<Purchase> purchaseList = purchaseMapper.selectTradingDrugs();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    @Override
    public List<Purchase> searchBuyDrug(SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseMapper.searchBuyDrug(searchDTO);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 查询药品详情明细
     *
     * @return 药品采购明细
     */
    @Override
    public List<Purchase> queryDrugInfo() {
        List<Purchase> purchaseList = purchaseMapper.queryDrugInfo();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    /**
     * 采购药品信息搜索
     *
     * @param searchDTO
     * @return yp info
     */
    @Override
    public List<Purchase> searchDrugInfo(SearchDTO searchDTO) {
        List<Purchase> purchaseList = purchaseMapper.searchDrugInfo(searchDTO);
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }

    public void setPurchaseMapper(PurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }
}
