package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemAuth;
import com.scda.backend.api.system.ISystemAuthService;
import com.scda.backend.system.mapper.SystemAuthMapper;

/**
* @author 10045
* @description 针对表【system_auth(系统权限)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemAuthServiceImpl extends ServiceImpl<SystemAuthMapper, SystemAuth>
    implements ISystemAuthService{

}




