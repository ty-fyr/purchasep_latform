package com.hospital.purchase.mapper;

import com.hospital.purchase.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //登录
    User seleAll(@Param("username") String username, @Param("password") String password);
}