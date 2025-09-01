package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemUserLoginInfo;

/**
* @author 10045
* @description 针对表【system_user_login_info(系统用户登录日志)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemUserLoginInfoService extends IService<SystemUserLoginInfo> {

}
