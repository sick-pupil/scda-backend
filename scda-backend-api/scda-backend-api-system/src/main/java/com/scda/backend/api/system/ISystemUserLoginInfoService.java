package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.system.dto.SystemUserLoginInfoCreateDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoReadDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserLoginInfoDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_user_login_info(系统用户登录日志)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemUserLoginInfoService extends IService<SystemUserLoginInfo> {

    void create(SystemUserLoginInfoCreateDTO req) throws BusinessException;

    List<SystemUserLoginInfoDetailVO> read(SystemUserLoginInfoReadDTO req);

    Page<SystemUserLoginInfoDetailVO> readPage(SystemUserLoginInfoReadDTO req);

    void update(SystemUserLoginInfoUpdateDTO req) throws BusinessException;

    void delete(SystemUserLoginInfoDeleteDTO req) throws BusinessException;
}
