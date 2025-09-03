package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemRelRoleAuthCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleAuthDetailVO;
import com.scda.backend.api.system.vo.SystemRelRoleMenuDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelRoleAuth;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_role_auth(系统角色权限关联表)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelRoleAuthService extends IService<SystemRelRoleAuth> {

    void create(SystemRelRoleAuthCreateDTO req) throws BusinessException;

    List<SystemRelRoleAuthDetailVO> read(SystemRelRoleAuthReadDTO req);

    Page<SystemRelRoleAuthDetailVO> readPage(SystemRelRoleAuthReadDTO req);

    Boolean checkExists(SystemRelRoleAuthReadDTO req) throws BusinessException;

    void update(SystemRelRoleAuthUpdateDTO req) throws BusinessException;

    void delete(SystemRelRoleAuthDeleteDTO req) throws BusinessException;
}
