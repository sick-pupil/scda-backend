package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemTenantCreateDTO;
import com.scda.backend.api.system.dto.SystemTenantDeleteDTO;
import com.scda.backend.api.system.dto.SystemTenantReadDTO;
import com.scda.backend.api.system.dto.SystemTenantUpdateDTO;
import com.scda.backend.api.system.vo.SystemTenantDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemTenant;
import com.scda.backend.api.system.ISystemTenantService;
import com.scda.backend.system.mapper.SystemTenantMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_tenant(系统租户)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemTenantServiceImpl extends ServiceImpl<SystemTenantMapper, SystemTenant>
    implements ISystemTenantService{

    @Override
    public void create(SystemTenantCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemTenantDetailVO> read(SystemTenantReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemTenantDetailVO> readPage(SystemTenantReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemTenantReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemTenantUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemTenantDeleteDTO req) throws BusinessException {

    }
}




