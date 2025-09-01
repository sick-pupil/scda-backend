package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRoleDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRole;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_role(系统角色)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRoleService extends IService<SystemRole> {

    void create(SystemRoleCreateDTO req) throws BusinessException;

    List<SystemRoleDetailVO> read(SystemRoleReadDTO req);

    Page<SystemRoleDetailVO> readPage(SystemRoleReadDTO req);

    Boolean checkExists(SystemRoleReadDTO req) throws BusinessException;

    void update(SystemRoleUpdateDTO req) throws BusinessException;

    void delete(SystemRoleDeleteDTO req) throws BusinessException;
}
