package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemRelUserRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelUserRoleDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelUserRole;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_user_role(系统用户角色关联表)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelUserRoleService extends IService<SystemRelUserRole> {

    void create(SystemRelUserRoleCreateDTO req) throws BusinessException;

    List<SystemRelUserRoleDetailVO> read(SystemRelUserRoleReadDTO req);

    Page<SystemRelUserRoleDetailVO> readPage(SystemRelUserRoleReadDTO req);

    Boolean checkExists(SystemRelUserRoleReadDTO req) throws BusinessException;

    void update(SystemRelUserRoleUpdateDTO req) throws BusinessException;

    void delete(SystemRelUserRoleDeleteDTO req) throws BusinessException;
}
