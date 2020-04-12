package com.ufutx.mpdemo;

import com.ufutx.mpdemo.entity.User;
import com.ufutx.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {



    // 查询User表中的所有数据
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        for(User user: users){
            System.out.println(user);
        }

    }
}
