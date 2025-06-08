package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderStep;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderStepService;
import com.scda.backend.spider.mapper.SpiderStepMapper;

/**
* @author 10045
* @description 针对表【spider_step(抓取步骤)】的数据库操作Service实现
* @createDate 2025-06-08 18:04:41
*/
@Service
public class SpiderStepServiceImpl extends ServiceImpl<SpiderStepMapper, SpiderStep>
    implements ISpiderStepService{

}




