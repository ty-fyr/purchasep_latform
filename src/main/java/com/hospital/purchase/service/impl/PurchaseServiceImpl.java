package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.dto.SearchDto;
import com.hospital.purchase.mapper.PurchaseMapper;
import com.hospital.purchase.service.PurchaseService;
import com.hospital.purchase.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    //查询所有
    @Override
    public List<Purchase> selectAll() {
        List<Purchase> purchases = purchaseMapper.selectAll();
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getStartTime()!=null&&!"".equals(purchases.get(i).getStartTime())) {
                purchases.get(i).setStartTimeStr(DateUtils.dateFormat(purchases.get(i).getStartTime(), "yyyy-MM-dd"));
            }
            if (purchases.get(i).getOverTime()!=null&&!"".equals(purchases.get(i).getOverTime())) {
                purchases.get(i).setOverTimeStr(DateUtils.dateFormat(purchases.get(i).getOverTime(), "yyyy-MM-dd"));
            }
            if (purchases.get(i).getActivateTime()!=null&&!"".equals(purchases.get(i).getActivateTime())) {
                purchases.get(i).setActivateTimeStr(DateUtils.dateFormat(purchases.get(i).getActivateTime(), "yyyy-MM-dd"));
            }
            if (purchases.get(i).getSubmitTime()!=null&&!"".equals(purchases.get(i).getSubmitTime())) {
                purchases.get(i).setSubmitTimeStr(DateUtils.dateFormat(purchases.get(i).getSubmitTime(), "yyyy-MM-dd"));
            }
            if (purchases.get(i).getAssessorTime()!=null&&!"".equals(purchases.get(i).getAssessorTime())) {
                purchases.get(i).setAssessorTimeStr(DateUtils.dateFormat(purchases.get(i).getAssessorTime(), "yyyy-MM-dd"));
            }
            if (purchases.get(i).getDescripId().equals(0)){
                purchases.get(i).setDescripIdStr("已入库");
            }else if(purchases.get(i).getDescripId().equals(1)){
                purchases.get(i).setDescripIdStr("未入库");
            }
        }
        return purchases;
    }

    //按采购单查询
    @Override
    public List<Purchase> selectBySearchBean(SearchDto searchDto) {
        return purchaseMapper.selectBySearchBean(searchDto);
    }
}
