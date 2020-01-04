package com.hospital.purchase.service;

import com.hospital.purchase.domain.DrugCategory;
import com.hospital.purchase.domain.DrugInformationSheet;
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
    List<DummyPositionSensitiveRecordWithChildren> findall ();

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
     * @return
     */
    List<DummyPositionSensitiveRecordWithChildren> finxx();
}
