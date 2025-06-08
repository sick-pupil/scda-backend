package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderUserAgentLog;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_user_agent_log(抓取使用user-agent代理池获取日志)】的数据库操作Service
* @createDate 2025-06-08 18:04:41
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderUserAgentLogService extends IService<SpiderUserAgentLog> {

}
