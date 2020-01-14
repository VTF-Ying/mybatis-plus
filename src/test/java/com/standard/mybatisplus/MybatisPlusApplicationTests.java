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

    //增加的测试
    @Test
    public void testInsert(){
        for (int i=0;i<5;i++){
            Users user = new Users();
            user.setName("李昱颖");
            user.setAge(3);
            user.setEmail("3335654007@qq.com");
            int insert = usersMapper.insert(user);
            System.out.println(insert);
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Users users = new Users();

        users.setId(1L);
        users.setAge(100);
        int i = usersMapper.updateById(users);
        System.out.println(i);

    }

}
