package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderSample;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_sample(抓取样本)】的数据库操作Service
* @createDate 2025-06-08 18:04:41
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderSampleService extends IService<SpiderSample> {

}
