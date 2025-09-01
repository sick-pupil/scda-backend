package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemDict;
import com.scda.backend.api.system.ISystemDictService;
import com.scda.backend.system.mapper.SystemDictMapper;

/**
* @author 10045
* @description 针对表【system_dict(系统字典)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemDictServiceImpl extends ServiceImpl<SystemDictMapper, SystemDict>
    implements ISystemDictService{

}




