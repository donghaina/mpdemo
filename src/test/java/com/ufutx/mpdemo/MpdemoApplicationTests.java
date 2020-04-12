package com.ufutx.mpdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ufutx.mpdemo.entity.User;
import com.ufutx.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("任我行");
        user.setAge(42);
        user.setEmail("renwoxing@qq.com");

        // 手动设置时间
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println("Insert:" + insert);
    }

    // 更新操作
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1249323663673647106L);
        user.setEmail("John@qq.com");

        int row = userMapper.updateById(user);
        System.out.println("Update:" + row);
    }

    // 测试乐观锁
    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(1249334263631941634L);
        user.setAge(200);
        userMapper.updateById(user);
    }

    // 多个ID批量查询
    @Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    // 多条件查询
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        // 1. 创建page对象
        // 2. 传入当前页和每页记录数
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getCurrent()); // 当前页
        System.out.println(page.getRecords()); // 每页数据集合
        System.out.println(page.getSize());  // 每页记录数
        System.out.println(page.getTotal());  // 总记录数
        System.out.println(page.getPages());   // 总页数
        System.out.println(page.hasNext());  // 是否有下一页
        System.out.println(page.hasPrevious());   // 是否有上一页
    }

    // 删除操作 物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    // 批量删除 物理删除
    @Test
    public void testDeleteBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(2,3));
        System.out.println(result);
    }

    // 删除操作 逻辑删除
    @Test
    public void testLogicDeleteById() {
        int result = userMapper.deleteById(1249349151917993985L);
        System.out.println(result);
    }
}
