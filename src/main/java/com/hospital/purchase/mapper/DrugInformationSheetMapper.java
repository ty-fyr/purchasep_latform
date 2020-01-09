package com.hospital.purchase.mapper;


import com.hospital.purchase.domain.*;
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
     *添加药品信息
     * @return
     */
    int xxadd(DrugInformationSheet children);

    /**
     * 查询药品信息
     * @return
     */
    List<DrugInformationSheet> finxx();

    /**
     * 生产企业
     * @return
     */
    List<Enterprise> scqy();

    /**
     *质量层次
     * @return
     */
    List<QualityLevel> quali();

    /**
     *修改查询
     * @return
     */
    DrugInformationSheet uptefind(Integer id);

    /**
     * 单位
     * @return
     */
    List<Units> unfind();

    /**
     * 修改
     * @return
     */
    int upayy(DrugInformationSheet children);

    /**
     * 模糊查询药品品目
     * @return
     */
    List<DrugInformationSheet> mhfind(DrugInformationSheet children);

    /**
     * 删除药品品目
     * @return
     */
    int delfind(int ids);

    //查询全部药品信息
    List<DrugInformationSheet> selecetDrugInformationSheet();
    //查询全部药品信息
    List<DrugInformationSheet> selecetDrugInformationSheet1();

    //条件查询
    List<DrugInformationSheet> findSerchBean(SelectDto selectDto);

    //通过id查询单条药品信息
    DrugInformationSheet selecetDrugInformationSheetById(Integer drugId);

    //修改药品维护信息
    void updateInfo(SelectDto selectDto);
}


