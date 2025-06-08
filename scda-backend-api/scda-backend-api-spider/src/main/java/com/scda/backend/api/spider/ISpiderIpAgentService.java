package com.scda.backend.api.spider;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.spider.entity.SpiderIpAgent;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 10045
* @description 针对表【spider_ip_agent(ip代理池)】的数据库操作Service
* @createDate 2025-06-08 17:57:36
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface ISpiderIpAgentService extends IService<SpiderIpAgent> {

}
