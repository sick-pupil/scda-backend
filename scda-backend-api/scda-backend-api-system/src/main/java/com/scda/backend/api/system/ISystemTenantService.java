package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemTenantCreateDTO;
import com.scda.backend.api.system.dto.SystemTenantDeleteDTO;
import com.scda.backend.api.system.dto.SystemTenantReadDTO;
import com.scda.backend.api.system.dto.SystemTenantUpdateDTO;
import com.scda.backend.api.system.vo.SystemTenantDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemTenant;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_tenant(系统租户)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemTenantService extends IService<SystemTenant> {

    void create(SystemTenantCreateDTO req) throws BusinessException;

    List<SystemTenantDetailVO> read(SystemTenantReadDTO req);

    Page<SystemTenantDetailVO> readPage(SystemTenantReadDTO req);

    Boolean checkExists(SystemTenantReadDTO req) throws BusinessException;

    void update(SystemTenantUpdateDTO req) throws BusinessException;

    void delete(SystemTenantDeleteDTO req) throws BusinessException;
}
