package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PurchaseMapper {
	
	/*
     * 按采购单查询
     */
    List<Purchase> selectByPrimaryName ();
    /*
    模糊查询
     */
    List<Purchase> selectByMHCX (Purchase purchase);


	
    int deleteByPrimaryKey(Integer purId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}