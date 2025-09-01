package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;
import com.scda.backend.api.system.ISystemUserLoginInfoService;
import com.scda.backend.system.mapper.SystemUserLoginInfoMapper;

/**
* @author 10045
* @description 针对表【system_user_login_info(系统用户登录日志)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemUserLoginInfoServiceImpl extends ServiceImpl<SystemUserLoginInfoMapper, SystemUserLoginInfo>
    implements ISystemUserLoginInfoService{

}




