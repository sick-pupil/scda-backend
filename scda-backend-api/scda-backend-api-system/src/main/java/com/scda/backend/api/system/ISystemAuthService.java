package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemAuthCreateDTO;
import com.scda.backend.api.system.dto.SystemAuthDeleteDTO;
import com.scda.backend.api.system.dto.SystemAuthReadDTO;
import com.scda.backend.api.system.dto.SystemAuthUpdateDTO;
import com.scda.backend.api.system.vo.SystemAuthDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemAuth;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_auth(系统权限)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemAuthService extends IService<SystemAuth> {

    void create(SystemAuthCreateDTO req) throws BusinessException;

    List<SystemAuthDetailVO> read(SystemAuthReadDTO req);

    Page<SystemAuthDetailVO> readPage(SystemAuthReadDTO req);

    Boolean checkExists(SystemAuthReadDTO req) throws BusinessException;

    void update(SystemAuthUpdateDTO req) throws BusinessException;

    void delete(SystemAuthDeleteDTO req) throws BusinessException;
}
