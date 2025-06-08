package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderUserAgent;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_user_agent(user-agent代理池)】的数据库操作Service
* @createDate 2025-06-08 18:04:41
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderUserAgentService extends IService<SpiderUserAgent> {

}
