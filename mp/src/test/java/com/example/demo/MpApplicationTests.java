package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpApplicationTests {


	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

	@Test
	public void insertUser() {
		User user  = new User();
		user.setAge(1);
		user.setName("yi6");
		user.setEmail("222222");
		int insert = userMapper.insert(user);
		System.out.print(insert);
		System.out.print(user);

	}


    @Test
    public void testIdWorker() {
        long l = new IdWorker().nextId();
        System.out.print(l);

    }

    /**
     * 跟新
     */
    @Test
    public void updateUser(){
	    //一定要有version，乐观锁的字段，否则字段更新不成功，其他的却成功了
        User user = new User();
        user.setId(1124200835878813698L);
        user.setName("易分锐67777");
        int i = userMapper.updateById(user);
        System.out.print(i);
    }

    /**
     * 更新版本
     */
    @Test
    public void updateFindUser(){
        User user = userMapper.selectById(1124200835878813698L);
        user.setName("易分锐666");
        int i = userMapper.updateById(user);
        System.out.print(i);
    }

    /**
     * map查询
     */
    @Test
    public void selectMap(){
        Map hashma = new HashMap();
        hashma.put("id",1124200835878813698L);
        List<User> user = userMapper.selectByMap(hashma);
        user.forEach(System.out::println);
    }


    /**
     * 分页
     */
    @Test
    public void selectFenYe(){
        Page<User> page = new Page<User>(1,5);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getTotal());
    }


    /**
     * 分页map
     */
    @Test
    public void selectFenYeMap(){
        Page<User> page = new Page<User>(1,5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        List<Map<String, Object>> records = mapIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getTotal());
    }


    /**
     * 批量删除、根据map删除
     */
    @Test
    public void deleteBatchs(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1124200835878813698L));

        /*Map hashma = new HashMap();
        hashma.put("id",1124200835878813698L);

        int i1 = userMapper.deleteByMap(hashma);*/
        System.out.println(i);
    }

    /**
     * wrapper查询
     */
    @Test
    public void queryWrapper(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1124200835878813698L));


        System.out.println(i);
    }

    /**
     * wrapper删除
     */
    @Test
    public void deleteWrapper(){
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.isNull("name")
                .ge("age",12).isNotNull("email");
        int delete = userMapper.delete(objectQueryWrapper);
        System.out.println(delete);
    }

    /**
     * selectOne
     */
    @Test
    public void testSelectOne(){
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("name","yi");
        User user = userMapper.selectOne(objectQueryWrapper);
        System.out.println(user);
    }


    /**
     * between
     */
    @Test
    public void testBetween(){
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.between("age", 20, 30);
        Integer integer = userMapper.selectCount(objectQueryWrapper);
        System.out.println(integer);
    }

}
