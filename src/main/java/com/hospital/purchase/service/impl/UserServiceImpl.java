package com.hospital.purchase.service.impl;

import com.hospital.purchase.domain.User;
import com.hospital.purchase.mapper.UserMapper;
import com.hospital.purchase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    //
    @Override
    public User seleAll(String username,String password) {
        return userMapper.seleAll(username,password);
    }
}
