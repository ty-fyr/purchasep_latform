package com.hospital.purchase.service;

import com.hospital.purchase.domain.DrugCategory;
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
}
