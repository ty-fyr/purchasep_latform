package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.Hospital;
import com.hospital.purchase.domain.dto.SearchDTO;

import java.util.List;

public interface HospitalMapper {

    //查询医院
    Hospital selectHospital(String hospitalName);

}