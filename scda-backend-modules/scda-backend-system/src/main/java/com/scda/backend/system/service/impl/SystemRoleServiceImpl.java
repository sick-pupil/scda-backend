package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRole;
import com.scda.backend.api.system.ISystemRoleService;
import com.scda.backend.system.mapper.SystemRoleMapper;

/**
* @author 10045
* @description 针对表【system_role(系统角色)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole>
    implements ISystemRoleService{

}




