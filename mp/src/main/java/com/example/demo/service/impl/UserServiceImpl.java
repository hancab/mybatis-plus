package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerivice {

    @Autowired
    private UserMapper userMapper;


    public Page<User> getUser(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
       return userMapper.selectPage(new Page<>(),queryWrapper);
    }
}
