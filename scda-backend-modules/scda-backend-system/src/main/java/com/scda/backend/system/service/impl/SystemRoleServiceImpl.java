package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRoleDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRole;
import com.scda.backend.api.system.ISystemRoleService;
import com.scda.backend.system.mapper.SystemRoleMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_role(系统角色)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole>
    implements ISystemRoleService{

    @Override
    public void create(SystemRoleCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemRoleDetailVO> read(SystemRoleReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemRoleDetailVO> readPage(SystemRoleReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemRoleReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemRoleUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemRoleDeleteDTO req) throws BusinessException {

    }
}




