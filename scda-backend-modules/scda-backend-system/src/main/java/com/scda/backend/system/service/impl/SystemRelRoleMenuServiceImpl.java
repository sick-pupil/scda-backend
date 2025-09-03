package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemRelRoleMenuCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleMenuUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleMenuDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelRoleMenu;
import com.scda.backend.api.system.ISystemRelRoleMenuService;
import com.scda.backend.system.mapper.SystemRelRoleMenuMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_role_menu】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelRoleMenuServiceImpl extends ServiceImpl<SystemRelRoleMenuMapper, SystemRelRoleMenu>
    implements ISystemRelRoleMenuService{

    @Override
    public void create(SystemRelRoleMenuCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemRelRoleMenuDetailVO> read(SystemRelRoleMenuReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemRelRoleMenuDetailVO> readPage(SystemRelRoleMenuReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemRelRoleMenuReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemRelRoleMenuUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemRelRoleMenuDeleteDTO req) throws BusinessException {

    }
}




