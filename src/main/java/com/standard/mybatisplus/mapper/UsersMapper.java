package com.standard.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.standard.mybatisplus.entity.Users;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: mybatis-plus
 * @ClassName: UserMapper
 * @Description: TODO(用户 mapper)
 * @Author: VTF
 * @create: 2020-01-14 17:35
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
