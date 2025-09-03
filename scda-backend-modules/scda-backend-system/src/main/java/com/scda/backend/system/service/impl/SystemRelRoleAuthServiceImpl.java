package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemRelRoleAuthCreateDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthReadDTO;
import com.scda.backend.api.system.dto.SystemRelRoleAuthUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelRoleAuthDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelRoleAuth;
import com.scda.backend.api.system.ISystemRelRoleAuthService;
import com.scda.backend.system.mapper.SystemRelRoleAuthMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_role_auth(系统角色权限关联表)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelRoleAuthServiceImpl extends ServiceImpl<SystemRelRoleAuthMapper, SystemRelRoleAuth>
    implements ISystemRelRoleAuthService{

    @Override
    public void create(SystemRelRoleAuthCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemRelRoleAuthDetailVO> read(SystemRelRoleAuthReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemRelRoleAuthDetailVO> readPage(SystemRelRoleAuthReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemRelRoleAuthReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemRelRoleAuthUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemRelRoleAuthDeleteDTO req) throws BusinessException {

    }
}




