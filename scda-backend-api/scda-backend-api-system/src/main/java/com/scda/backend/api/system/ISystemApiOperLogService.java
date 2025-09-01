package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemApiOperLog;

/**
* @author 10045
* @description 针对表【system_api_oper_log(系统接口操作日志)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemApiOperLogService extends IService<SystemApiOperLog> {

}
