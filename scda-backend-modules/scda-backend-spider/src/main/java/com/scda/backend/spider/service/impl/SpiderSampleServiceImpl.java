package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderSample;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderSampleService;
import com.scda.backend.spider.mapper.SpiderSampleMapper;

/**
* @author 10045
* @description 针对表【spider_sample(抓取样本)】的数据库操作Service实现
* @createDate 2025-06-08 18:04:41
*/
@Service
public class SpiderSampleServiceImpl extends ServiceImpl<SpiderSampleMapper, SpiderSample>
    implements ISpiderSampleService{

}




