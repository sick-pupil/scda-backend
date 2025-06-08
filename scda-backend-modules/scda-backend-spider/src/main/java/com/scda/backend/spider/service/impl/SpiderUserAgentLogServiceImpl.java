package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderUserAgentLog;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderUserAgentLogService;
import com.scda.backend.spider.mapper.SpiderUserAgentLogMapper;

/**
* @author 10045
* @description 针对表【spider_user_agent_log(抓取使用user-agent代理池获取日志)】的数据库操作Service实现
* @createDate 2025-06-08 18:04:41
*/
@Service
public class SpiderUserAgentLogServiceImpl extends ServiceImpl<SpiderUserAgentLogMapper, SpiderUserAgentLog>
    implements ISpiderUserAgentLogService{

}




