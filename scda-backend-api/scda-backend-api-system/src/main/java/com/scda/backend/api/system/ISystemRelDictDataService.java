package com.scda.backend.api.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.system.entity.SystemRelDictData;

/**
* @author 10045
* @description 针对表【system_rel_dict_data(系统字典与字典数据关联)】的数据库操作Service
* @createDate 2025-09-01 19:49:33
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISystemRelDictDataService extends IService<SystemRelDictData> {

}
