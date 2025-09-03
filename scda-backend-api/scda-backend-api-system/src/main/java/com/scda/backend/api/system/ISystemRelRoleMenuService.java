package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemRelRoleMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleMenuDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelRoleMenu;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_role_menu】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelRoleMenuService extends IService<SystemRelRoleMenu> {

    void create(SystemRelRoleMenuCreateDTO req) throws BusinessException;

    List<SystemRelRoleMenuDetailVO> read(SystemRelRoleMenuReadDTO req);

    Page<SystemRelRoleMenuDetailVO> readPage(SystemRelRoleMenuReadDTO req);

    Boolean checkExists(SystemRelRoleMenuReadDTO req) throws BusinessException;

    void update(SystemRelRoleMenuUpdateDTO req) throws BusinessException;

    void delete(SystemRelRoleMenuDeleteDTO req) throws BusinessException;
}
