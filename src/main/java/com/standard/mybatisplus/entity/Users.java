package com.standard.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

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

    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    //记录  用于 乐观锁操作
    @TableField(fill = FieldFill.INSERT)
    //这个注释让乐观锁修改后自增
    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
