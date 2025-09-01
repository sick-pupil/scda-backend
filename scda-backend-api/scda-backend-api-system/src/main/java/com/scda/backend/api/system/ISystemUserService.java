package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemUserCreateDTO;
import com.scda.backend.api.system.dto.SystemUserDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserReadDTO;
import com.scda.backend.api.system.dto.SystemUserUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemUser;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_user(系统用户)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemUserService extends IService<SystemUser> {

    void create(SystemUserCreateDTO req) throws BusinessException;

    List<SystemUserDetailVO> read(SystemUserReadDTO req);

    Page<SystemUserDetailVO> readPage(SystemUserReadDTO req);

    Boolean checkExists(SystemUserReadDTO req) throws BusinessException;

    void update(SystemUserUpdateDTO req) throws BusinessException;

    void delete(SystemUserDeleteDTO req) throws BusinessException;

}
