package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemDictData;

/**
* @author 10045
* @description 针对表【system_dict_data(系统字典数据)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemDictDataService extends IService<SystemDictData> {

}
