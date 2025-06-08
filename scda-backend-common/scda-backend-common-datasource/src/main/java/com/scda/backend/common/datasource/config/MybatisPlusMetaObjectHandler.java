package com.scda.backend.common.datasource.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.scda.backend.common.core.enums.DeletedEnum;
import com.scda.backend.common.core.enums.VersionEnum;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "creatorUserId", Long.class, 123456L);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updatorUserId", Long.class, null);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, null);
        this.strictInsertFill(metaObject, "tenantId", Long.class, 123L);
        this.strictInsertFill(metaObject, "deleted", Integer.class, DeletedEnum.NON_DELETED.getDeleted());
        this.strictInsertFill(metaObject, "version", Integer.class, VersionEnum.INIT_VERSION.getVersion());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatorUserId", Long.class, 123456L);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}