package com.scda.backend.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.system.entity.SystemDictData;
import com.scda.backend.api.system.ISystemDictDataService;
import com.scda.backend.system.mapper.SystemDictDataMapper;

/**
* @author 10045
* @description 针对表【system_dict_data(系统字典数据)】的数据库操作Service实现
* @createDate 2025-09-01 19:49:33
*/
@Service
public class SystemDictDataServiceImpl extends ServiceImpl<SystemDictDataMapper, SystemDictData>
    implements ISystemDictDataService{

}




