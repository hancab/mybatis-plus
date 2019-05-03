package com.example.demo;

import com.example.demo.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yi on 2019/5/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {
    @Autowired
    private UserMapper userMapper;


}
