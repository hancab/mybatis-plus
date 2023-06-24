package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;

public interface UserSerivice {
     Page<User>  getUser();
}
