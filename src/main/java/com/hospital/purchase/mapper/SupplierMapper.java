package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Supplier;
import com.hospital.purchase.domain.dto.VO;

import java.util.List;

public interface SupplierMapper {

    //张  供货商模糊查询
    List<Supplier> selectSupplierMHCX(VO vo);

    //查询全部供货商
    List<Supplier> findSupplier();


    int deleteByPrimaryKey(Integer supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierId);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}