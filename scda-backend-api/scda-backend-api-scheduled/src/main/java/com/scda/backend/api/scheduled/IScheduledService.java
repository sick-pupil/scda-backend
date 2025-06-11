package com.scda.backend.api.scheduled;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = RuntimeException.class)
public interface IScheduledService {
}
