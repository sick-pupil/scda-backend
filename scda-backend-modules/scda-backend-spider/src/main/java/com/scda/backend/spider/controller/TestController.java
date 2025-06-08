package com.scda.backend.spider.controller;

import com.scda.backend.api.spider.ISpiderUserAgentLogService;
import com.scda.backend.api.spider.entity.SpiderUserAgentLog;
import com.scda.backend.spider.service.ITestService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final ITestService testService;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ISpiderUserAgentLogService spiderUserAgentLogService;

    @GetMapping("/redisson")
    public void redissonTest(@RequestParam("keyName") String keyName) {
        RBucket<String> bucket = redissonClient.getBucket(keyName);
        bucket.set("123");
    }

    @GetMapping("/insert")
    public void mpInsertTest() {
        SpiderUserAgentLog log = new SpiderUserAgentLog();
        log.setStepId(1L);
        log.setUserAgentId(1L);
        log.setCreatorUserId(1L);
        spiderUserAgentLogService.save(log);
    }

    @GetMapping("/update")
    public void mpUpdateTest(@RequestParam("id") Long id) {
        SpiderUserAgentLog oldLog = spiderUserAgentLogService.getById(id);
        oldLog.setStepId(2L);
        oldLog.setUserAgentId(23L);
        oldLog.setCreatorUserId(2L);
        spiderUserAgentLogService.updateById(oldLog);
    }

    @GetMapping("/delete")
    public void mpDeleteTest(@RequestParam("id") Long id) {
        SpiderUserAgentLog log = new SpiderUserAgentLog();
        log.setId(id);
        spiderUserAgentLogService.removeById(log);
    }
}
