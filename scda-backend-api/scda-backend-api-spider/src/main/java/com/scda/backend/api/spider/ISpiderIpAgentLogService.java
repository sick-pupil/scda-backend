package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderIpAgentLog;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_ip_agent_log(抓取使用代理池获取日志)】的数据库操作Service
* @createDate 2025-06-08 18:03:07
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderIpAgentLogService extends IService<SpiderIpAgentLog> {

}
