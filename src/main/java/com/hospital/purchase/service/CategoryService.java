
package com.hospital.purchase.service;

import com.hospital.purchase.domain.*;
import org.apache.poi.hslf.record.DummyPositionSensitiveRecordWithChildren;

import java.util.List;

/**
 * @author shkstart
 * @create YEAR−YEAR−{MONTH}-30 18:10
 */

public interface CategoryService {

/**
     * 药品品目查询
     * @return
     */

    List<DrugInformationSheet> findall ();
    /**
     *添加药品信息
     * @return
     */
    int xxadd(DrugInformationSheet children);


/**
     * 药品类型查询
     * @return
     */

    List<DrugCategory> seldrugc();

/**
     *添加药品品目
     * @return
     */

    int findadd(DrugInformationSheet children);

/**
     * 查询药品信息
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


}

