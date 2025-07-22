package com.scda.backend.api.scheduled;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.scheduled.entity.ScheduledTriggers;

/**
* @author 10045
* @description 针对表【scheduled_triggers】的数据库操作Service
* @createDate 2025-07-22 21:03:02
*/
@Transactional(rollbackFor = BusinessException.class)
public interface IScheduledTriggersService extends IService<ScheduledTriggers> {

}
