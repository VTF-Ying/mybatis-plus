package com.standard.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.standard.mybatisplus.entity.Users;
import com.standard.mybatisplus.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Users user = new Users();
            user.setName("李昱颖");
            user.setAge(20);
            user.setEmail("3335654007@qq.com");
            int insert = usersMapper.insert(user);
            System.out.println(insert);
            System.out.println(user);

    }
    @Test
    public void testUpdate(){
        Users users = new Users();

        users.setId(1217336318476591105L);
        users.setName("武凯");
        int i = usersMapper.updateById(users);
        System.out.println(i);

    }

    //乐观锁测试
    @Test
    public void testUpdateVersion(){
        Users users = usersMapper.selectById(1217382503665008641L);
        users.setName("李四");
        users.setAge(12);
//        users.setVersion(users.getVersion()-1);
        int i = usersMapper.updateById(users);
        System.out.println(i);

    }

    @Test
    public void testSelectById(){
        Users users = usersMapper.selectById(1217280620170448897L);
        System.out.println("\r"+users+"\r");

    }

    //多个ID
    @Test
    public void testSelectBatchIds(){
        List<Users> users = usersMapper.selectBatchIds(Arrays.asList(1, 2, 1217280620170448897L));
        users.forEach(System.out::println);

    }

    //查询所有
    @Test
    public void testSelectList(){
        List<Users> users = usersMapper.selectList(null);
        users.forEach(System.out::println);

    }

    //多条精准件查询
    @Test
    public void testSelectByMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","张三");
        map.put("age",6);
        List<Users> users = usersMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

   // 测试分页
    @Test
    public void testSelectPage(){
        //new Page<Users>(current,size);  current：当前页  size:每页显示的条数
        Page<Users> page = new Page<Users>(2,2);
        Page<Users> usersPage = usersMapper.selectPage(page, null);
        System.out.println("*********************");
        List<Users> records = usersPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("当前第几页:"+page.getCurrent());   //当前第几页
        System.out.println("每页几条数据:"+page.getSize());      //每页几条数据
        System.out.println("一共有几页:"+page.getTotal());     //一共有几页
        System.out.println("是否有下一页:"+page.hasNext());      //是否有下一页
        System.out.println("是否有上一页:"+page.hasPrevious());  //是否有上一页
        System.out.println("*********************");
    }

    @Test
    public void testDeleteById(){
        int i = usersMapper.deleteById(1217280620170448897L);
        System.out.println("=========================");
        System.out.println(i);
        System.out.println("=========================");
    }

    @Test
    public void testDeleteBatchIds(){
        int i = usersMapper.deleteBatchIds(Arrays.asList(4L,5L));
        System.out.println("=========================");
        System.out.println(i);
        System.out.println("=========================");
    }

    @Test
    public void deleteByMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","李四");
        int i = usersMapper.deleteByMap(map);
        System.out.println("=========================");
        System.out.println(i);
        System.out.println("=========================");
    }

    @Test
    public void deleteById(){
        int i = usersMapper.deleteById(1217382503665008641L);

        if (i==0){
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }

    }


    @Test
    public void test(){
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",12).like("name","李");
        List<Users> users = usersMapper.selectList(queryWrapper);
        System.out.println("==============================");
        users.forEach(System.out::println);
        System.out.println("==============================");
    }
}
