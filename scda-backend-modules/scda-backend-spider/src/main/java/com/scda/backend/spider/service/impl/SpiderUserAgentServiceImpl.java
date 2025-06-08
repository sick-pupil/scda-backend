package com.scda.backend.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.spider.entity.SpiderUserAgent;
import org.springframework.stereotype.Service;

import com.scda.backend.api.spider.ISpiderUserAgentService;
import com.scda.backend.spider.mapper.SpiderUserAgentMapper;

/**
* @author 10045
* @description 针对表【spider_user_agent(user-agent代理池)】的数据库操作Service实现
* @createDate 2025-06-08 18:04:41
*/
@Service
public class SpiderUserAgentServiceImpl extends ServiceImpl<SpiderUserAgentMapper, SpiderUserAgent>
    implements ISpiderUserAgentService{

}




