package com.scda.backend.spider.controller;

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

    @GetMapping("/redisson")
    public void test(@RequestParam("keyName") String keyName) {
        RBucket<String> bucket = redissonClient.getBucket(keyName);
        bucket.set("123");
    }
}
