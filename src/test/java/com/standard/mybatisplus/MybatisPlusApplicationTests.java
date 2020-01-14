package com.standard.mybatisplus;

import com.standard.mybatisplus.entity.Users;
import com.standard.mybatisplus.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void contextLoads() {
        List<Users> users = usersMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
