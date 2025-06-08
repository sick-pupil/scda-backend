package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderInstance;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_instance(抓取实例)】的数据库操作Service
* @createDate 2025-06-08 17:41:47
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderInstanceService extends IService<SpiderInstance> {

}
