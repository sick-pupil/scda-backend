package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemTenant;
import com.scda.backend.api.system.ISystemTenantService;
import com.scda.backend.system.mapper.SystemTenantMapper;

/**
* @author 10045
* @description 针对表【system_tenant(系统租户)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemTenantServiceImpl extends ServiceImpl<SystemTenantMapper, SystemTenant>
    implements ISystemTenantService{

}




