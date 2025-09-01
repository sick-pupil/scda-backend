package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelUserRole;
import com.scda.backend.api.system.ISystemRelUserRoleService;
import com.scda.backend.system.mapper.SystemRelUserRoleMapper;

/**
* @author 10045
* @description 针对表【system_rel_user_role(系统用户角色关联表)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelUserRoleServiceImpl extends ServiceImpl<SystemRelUserRoleMapper, SystemRelUserRole>
    implements ISystemRelUserRoleService{

}




