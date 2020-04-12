package com.ufutx.mpdemo;

import com.ufutx.mpdemo.entity.User;
import com.ufutx.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {



    // 查询User表中的所有数据
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
//        Assert.assertEquals(5, users.size());
//        users.forEach(System.out::println);
        for(User user: users){
            System.out.println(user);
        }

    }

    @Test
    public void addUser(){
        User user = new User();
        user.setName("James");
        user.setAge(35);
        user.setEmail("James@qq.com");

        // 手动设置时间
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println("Insert:" + insert);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1249323663673647106L);
        user.setEmail("John@qq.com");

        int row = userMapper.updateById(user);
        System.out.println("Update:" + row);
    }

}
