package com.scda.backend.api.scheduled;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.scheduled.entity.ScheduledRelJobTrigger;

import java.util.List;

/**
* @author 10045
* @description 针对表【scheduled_rel_job_trigger】的数据库操作Service
* @createDate 2025-07-22 21:00:37
*/
@Transactional(rollbackFor = BusinessException.class)
public interface IScheduledRelJobTriggerService extends IService<ScheduledRelJobTrigger> {

    List<ScheduledRelJobTrigger> getRelsByJobId(Long jobId);
}
