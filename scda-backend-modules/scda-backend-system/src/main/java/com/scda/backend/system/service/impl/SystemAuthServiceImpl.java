package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.*;
import com.scda.backend.api.system.vo.SystemAuthDetailVO;
import com.scda.backend.api.system.vo.SystemUserDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemAuth;
import com.scda.backend.api.system.ISystemAuthService;
import com.scda.backend.system.mapper.SystemAuthMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_auth(系统权限)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemAuthServiceImpl extends ServiceImpl<SystemAuthMapper, SystemAuth>
    implements ISystemAuthService{

    @Override
    public void create(SystemAuthCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemAuthDetailVO> read(SystemAuthReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemAuthDetailVO> readPage(SystemAuthReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemAuthReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemAuthUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemAuthDeleteDTO req) throws BusinessException {

    }
}




