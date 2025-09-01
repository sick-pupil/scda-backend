package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.system.dto.SystemUserCreateDTO;
import com.scda.backend.api.system.dto.SystemUserDeleteDTO;
import com.scda.backend.api.system.dto.SystemUserReadDTO;
import com.scda.backend.api.system.dto.SystemUserUpdateDTO;
import com.scda.backend.api.system.vo.SystemUserDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemUser;
import com.scda.backend.api.system.ISystemUserService;
import com.scda.backend.system.mapper.SystemUserMapper;

import java.util.List;

/**
* @author 10045
* @description 针对表【system_user(系统用户)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements ISystemUserService{

    @Override
    public void create(SystemUserCreateDTO req) throws BusinessException {

    }

    @Override
    public List<SystemUserDetailVO> read(SystemUserReadDTO req) {
        return null;
    }

    @Override
    public Page<SystemUserDetailVO> readPage(SystemUserReadDTO req) {
        return null;
    }

    @Override
    public Boolean checkExists(SystemUserReadDTO req) throws BusinessException {
        return null;
    }

    @Override
    public void update(SystemUserUpdateDTO req) throws BusinessException {

    }

    @Override
    public void delete(SystemUserDeleteDTO req) throws BusinessException {

    }
}




