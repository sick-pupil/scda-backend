package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderStep;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_step(抓取步骤)】的数据库操作Service
* @createDate 2025-06-08 18:04:41
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderStepService extends IService<SpiderStep> {

}
