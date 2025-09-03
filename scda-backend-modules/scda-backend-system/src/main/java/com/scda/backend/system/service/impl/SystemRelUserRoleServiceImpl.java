package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemRelUserRoleCreateDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleDeleteDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleReadDTO;
import com.scda.backend.api.system.dto.SystemRelUserRoleUpdateDTO;
import com.scda.backend.api.system.vo.SystemRelUserRoleDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemRelUserRole;
import com.scda.backend.api.system.ISystemRelUserRoleService;
import com.scda.backend.system.mapper.SystemRelUserRoleMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_rel_user_role(系统用户角色关联表)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemRelUserRoleServiceImpl extends ServiceImpl<SystemRelUserRoleMapper, SystemRelUserRole>
    implements ISystemRelUserRoleService{

    @Override
    public void create(SystemRelUserRoleCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemRelUserRoleDetailVO> read(SystemRelUserRoleReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemRelUserRoleDetailVO> readPage(SystemRelUserRoleReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemRelUserRoleReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemRelUserRoleUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemRelUserRoleDeleteDTO req) throws BusinessException {

    }
}




