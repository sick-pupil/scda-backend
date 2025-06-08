package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderIpAgent;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderIpAgentService;
import com.scda.backend.spider.mapper.SpiderIpAgentMapper;

/**
* @author 10045
* @description 针对表【spider_ip_agent(ip代理池)】的数据库操作Service实现
* @createDate 2025-06-08 17:57:36
*/
@Service
public class SpiderIpAgentServiceImpl extends ServiceImpl<SpiderIpAgentMapper, SpiderIpAgent>
    implements ISpiderIpAgentService{

}




