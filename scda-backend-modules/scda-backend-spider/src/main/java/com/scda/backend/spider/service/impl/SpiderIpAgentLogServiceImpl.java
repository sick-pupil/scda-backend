package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderIpAgentLog;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderIpAgentLogService;
import com.scda.backend.spider.mapper.SpiderIpAgentLogMapper;

/**
* @author 10045
* @description 针对表【spider_ip_agent_log(抓取使用代理池获取日志)】的数据库操作Service实现
* @createDate 2025-06-08 18:03:07
*/
@Service
public class SpiderIpAgentLogServiceImpl extends ServiceImpl<SpiderIpAgentLogMapper, SpiderIpAgentLog>
    implements ISpiderIpAgentLogService{

}




