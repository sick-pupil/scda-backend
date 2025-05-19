package com.scda.backend.spider.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface ITestService {
}
