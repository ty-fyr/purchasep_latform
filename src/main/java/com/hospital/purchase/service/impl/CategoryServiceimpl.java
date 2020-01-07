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

 */
@Service
public class CategoryServiceimpl implements  CategoryService{

    @Autowired
    private DrugInformationSheetMapper drugInformationSheetMapper;

    @Override
    public List<DrugInformationSheet> findall() {
        return drugInformationSheetMapper.findall();
    }
    /**
     *
     * @return
     */
    public List<DrugCategory> seldrugc() {
        return drugInformationSheetMapper.seldrugc();
    }

    @Override
    public int findadd(DrugInformationSheet children) {
        return drugInformationSheetMapper.findadd(children);
    }

    @Override
    public List<DrugInformationSheet> finxx() {
        return drugInformationSheetMapper.finxx();
    }


}
