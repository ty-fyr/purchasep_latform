package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.mapper.DrugInformationSheetMapper;
import com.hospital.purchase.service.CategoryService;
import org.apache.poi.hslf.record.DummyPositionSensitiveRecordWithChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create YEAR−YEAR−{MONTH}-30 18:11
 */
@Service
public class CategoryServiceimpl implements  CategoryService{

    @Autowired
    private DrugInformationSheetMapper drugInformationSheetMapper;

    /**
     *
     * @return
     */
    public List<DummyPositionSensitiveRecordWithChildren> findall() {
        return drugInformationSheetMapper.findall();
    }


    public List<DrugCategory> seldrugc() {
        return drugInformationSheetMapper.seldrugc();
    }

    @Override
    public int findadd(DrugInformationSheet children) {
        return drugInformationSheetMapper.findadd(children);
    }


    @Override
    public List<DummyPositionSensitiveRecordWithChildren> finxx() {
        return drugInformationSheetMapper.finxx();
    }

}
