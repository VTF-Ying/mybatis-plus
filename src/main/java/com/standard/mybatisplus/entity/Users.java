package com.standard.mybatisplus.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ProjectName: mybatis-plus
 * @ClassName: User
 * @Description: TODO(用户实体类)
 * @Author: VTF
 * @create: 2020-01-14 17:31
 */

@Data
public class Users {

    private Long id;
    private String name;
    private int age;
    private String email;

}
