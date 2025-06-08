package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderInstance;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderInstanceService;
import com.scda.backend.spider.mapper.SpiderInstanceMapper;

/**
* @author 10045
* @description 针对表【spider_instance(抓取实例)】的数据库操作Service实现
* @createDate 2025-06-08 17:41:47
*/
@Service
public class SpiderInstanceServiceImpl extends ServiceImpl<SpiderInstanceMapper, SpiderInstance>
    implements ISpiderInstanceService {

}




