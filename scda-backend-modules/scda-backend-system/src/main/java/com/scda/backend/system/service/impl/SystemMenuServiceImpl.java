package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemMenu;
import com.scda.backend.api.system.ISystemMenuService;
import com.scda.backend.system.mapper.SystemMenuMapper;

/**
* @author 10045
* @description 针对表【system_menu(系统菜单)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu>
    implements ISystemMenuService{

}




