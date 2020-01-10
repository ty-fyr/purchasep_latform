package com.hospital.purchase.service;

import com.hospital.purchase.domain.DrugInformationSheet;
import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.Purchase;
import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.SearchDTO;
import com.hospital.purchase.domain.dto.VO;

import java.util.List;

public interface ZjqService {
    //张 按采购单查询
    List<Purchase> selectByPrimaryCGD ();
    //张  按供货商查询
    List<Purchase> selectByPrimaryGHS();
    //张  按医院查询
    List<Purchase> selectByPrimaryYY();
    //张  按交易药品查询
    List<Purchase> selectByPrimaryJYYY();
    //张 模糊查询
    List<Purchase> selectByPrimaryMHCX (SearchDTO searchDTO);
    //张  供货商模糊查询
    List<Supplier> selectSupplierMHCX(VO vo);

}
