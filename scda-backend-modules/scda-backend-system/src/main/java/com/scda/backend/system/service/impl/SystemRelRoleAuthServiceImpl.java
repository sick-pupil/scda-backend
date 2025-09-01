package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelRoleAuth;
import com.scda.backend.api.system.ISystemRelRoleAuthService;
import com.scda.backend.system.mapper.SystemRelRoleAuthMapper;

/**
* @author 10045
* @description 针对表【system_rel_role_auth(系统角色权限关联表)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelRoleAuthServiceImpl extends ServiceImpl<SystemRelRoleAuthMapper, SystemRelRoleAuth>
    implements ISystemRelRoleAuthService{

}




