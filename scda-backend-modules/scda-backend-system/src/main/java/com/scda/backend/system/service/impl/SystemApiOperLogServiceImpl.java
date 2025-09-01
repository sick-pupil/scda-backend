package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemApiOperLog;
import com.scda.backend.api.system.ISystemApiOperLogService;
import com.scda.backend.system.mapper.SystemApiOperLogMapper;

/**
* @author 10045
* @description 针对表【system_api_oper_log(系统接口操作日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemApiOperLogServiceImpl extends ServiceImpl<SystemApiOperLogMapper, SystemApiOperLog>
    implements ISystemApiOperLogService{

}




