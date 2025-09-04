package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemUserLoginInfoCreateDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoReadDTO;
import com.scda.backend.api.system.dto.SystemUserLoginInfoUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserLoginInfoDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;
import com.scda.backend.api.system.ISystemUserLoginInfoService;
import com.scda.backend.system.mapper.SystemUserLoginInfoMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_user_login_info(系统用户登录日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemUserLoginInfoServiceImpl extends ServiceImpl<SystemUserLoginInfoMapper, SystemUserLoginInfo>
    implements ISystemUserLoginInfoService{

    @Override
    public void create(SystemUserLoginInfoCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemUserLoginInfoDetailVO> read(SystemUserLoginInfoReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemUserLoginInfoDetailVO> readPage(SystemUserLoginInfoReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemUserLoginInfoReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemUserLoginInfoUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemUserLoginInfoDeleteDTO req) throws BusinessException {

    }
}




