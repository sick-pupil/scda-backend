package com.scda.backend.scheduled.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.scda.backend.api.scheduled.entity.ScheduledTriggers;
import com.scda.backend.api.scheduled.IScheduledTriggersService;
import com.scda.backend.scheduled.mapper.ScheduledTriggersMapper;

/**
* @author 10045
* @description 针对表【scheduled_triggers】的数据库操作Service实现
* @createDate 2025-07-22 21:03:02
*/
@Service
public class ScheduledTriggersServiceImpl extends ServiceImpl<ScheduledTriggersMapper, ScheduledTriggers>
    implements IScheduledTriggersService{

}




