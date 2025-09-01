package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelUserRole;

/**
* @author 10045
* @description 针对表【system_rel_user_role(系统用户角色关联表)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelUserRoleService extends IService<SystemRelUserRole> {

}
