package com.scda.backend.scheduled.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.scda.backend.api.scheduled.entity.ScheduledRelJobTrigger;
import com.scda.backend.api.scheduled.IScheduledRelJobTriggerService;
import com.scda.backend.scheduled.mapper.ScheduledRelJobTriggerMapper;

import java.util.ArrayList;
import java.util.List;

/**
* @author 10045
* @description 针对表【scheduled_rel_job_trigger】的数据库操作Service实现
* @createDate 2025-07-22 21:00:37
*/
@Service
public class ScheduledRelJobTriggerServiceImpl extends ServiceImpl<ScheduledRelJobTriggerMapper, ScheduledRelJobTrigger>
    implements IScheduledRelJobTriggerService{

    @Override
    public List<ScheduledRelJobTrigger> getRelsByJobId(Long jobId) {
        LambdaQueryWrapper<ScheduledRelJobTrigger> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(ScheduledRelJobTrigger::getJobId, jobId);
        List<ScheduledRelJobTrigger> relList = list(lambdaQueryWrapper);
        if(CollectionUtils.isEmpty(relList)) {
            return new ArrayList<>();
        } else {
            return relList;
        }
    }
}




