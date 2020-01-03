package com.hospital.purchase.mapper;


import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.hslf.record.DummyPositionSensitiveRecordWithChildren;

import java.util.List;

@Mapper
public interface DrugInformationSheetMapper {
    /**
     * 药品品目查询
     * @return
     */
    List<DummyPositionSensitiveRecordWithChildren> findall ();

    /**
     * 查询药品类别
     * @return
     */
    List<DrugCategory> seldrugc();}
