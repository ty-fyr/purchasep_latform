package com.hospital.purchase.mapper;


import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.dto.SelectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.hslf.record.DummyPositionSensitiveRecordWithChildren;

import java.util.List;

@Mapper
public interface DrugInformationSheetMapper {
    /**
     * 药品品目查询
     * @return
     */
    List<DrugInformationSheet> findall ();

    /**
     * 查询药品类别
     * @return
     */
    List<DrugCategory> seldrugc();

    /**
     *添加药品品目
     * @return
     */
    int findadd(DrugInformationSheet children);

    /**
     *添加药品品目
     * @return
     */
    int xxadd(DrugInformationSheet children);

    /**
     * 查询药品信息
     */
    List<DrugInformationSheet> finxx();

    //查询全部药品信息
    List<DrugInformationSheet> selecetDrugInformationSheet();

    //条件查询
    List<DrugInformationSheet> findSerchBean(SelectDto selectDto);

    //通过id查询单条药品信息
    DrugInformationSheet selecetDrugInformationSheetById(Integer drugId);
}


