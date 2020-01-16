package com.standard.mybatisplus.entity.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @ProjectName: mybatis-plus
 * @ClassName: MymetaObjectHandler
 * @Description: TODO(Mybatis-plus  自动填充操作)
 * @Author: VTF
 * @create: 2020-01-15 09:45
 */

@Component
public class MymetaObjectHandler implements MetaObjectHandler {
     private static final Logger LOGGER = LoggerFactory.getLogger(MymetaObjectHandler.class);

    /**
     *  insert 时自动填充 创建时间、更新时间、记录操作用于锁操作
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
        this.strictInsertFill(metaObject, "deleted", Integer.class, 1);
    }

    /**
     * update 时自动填充  更新时间、记录操作用于锁操作
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
