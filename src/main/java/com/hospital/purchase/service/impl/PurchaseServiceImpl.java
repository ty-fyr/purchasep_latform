package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    /**
     *  查询所有
     *
     * @return
     */
    @Override
    public List<Purchase> selectAll() {
        List<Purchase> purchaseList = purchaseMapper.selectAll();
        purchaseList.forEach(Purchase::transfer);
        return purchaseList;
    }
    //
//按采购单查询
    @Override
    public List<Purchase> selectBySearchBean(SearchDTO searchDto) {
        return purchaseMapper.selectBySearchBean(searchDto);
    }

    /*
     * 采购表查询
     *
     */
    @Override
    public List<Purchase> seleLike(Map<String, Object> map) {
        List<Purchase> list = purchaseMapper.seleLike(map);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getResult().equals(0)){
                list.get(i).setResultStr("审核通过");
            }else {
                list.get(i).setResultStr("未通过");
            }
        }
        return list;
    }

    /**
     * 采购表查询全部
     *
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
        return purchaseMapper.update(piId,purchase);
    }


    public PurchaseMapper getPurchaseMapper() {
        return purchaseMapper;
    }

    public void setPurchaseMapper(PurchaseMapper purchaseMapper) {
        this.purchaseMapper = purchaseMapper;
    }
}
