package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.*;
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
class CategoryServiceimpl implements  CategoryService{

    @Autowired
    private DrugInformationSheetMapper drugInformationSheetMapper;

    @Override
    public List<DrugInformationSheet> findall() {
        return drugInformationSheetMapper.findall();
    }

    @Override
    public int xxadd(DrugInformationSheet children) {
        return drugInformationSheetMapper.xxadd(children);
    }


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

    @Override
    public List<Enterprise> scqy() {
        return drugInformationSheetMapper.scqy();
    }

    @Override
    public List<QualityLevel> quali() {
        return drugInformationSheetMapper.quali();
    }

    @Override
    public DrugInformationSheet uptefind(Integer id) {
        return drugInformationSheetMapper.uptefind(id);
    }

    @Override
    public List<Units> unfind() {
        return drugInformationSheetMapper.unfind();
    }

    @Override
    public int upayy(DrugInformationSheet children) {
        int upayy = drugInformationSheetMapper.upayy(children);
        return upayy;
    }

    @Override
    public List<DrugInformationSheet> mhfind(DrugInformationSheet children) {
        return drugInformationSheetMapper.mhfind(children);
    }

    @Override
    public int delfind(int ids) {
        return drugInformationSheetMapper.delfind(ids);
    }

    @Override
    public List<DrugInformationSheet> dcfinayy() {
        return drugInformationSheetMapper.dcfinayy();
    }

    @Override
    public List<Units> findun() {
        return drugInformationSheetMapper.findun();
    }

    @Override
    public List<DrugCategory> fincat() {
        return drugInformationSheetMapper.fincat();
    }


}
