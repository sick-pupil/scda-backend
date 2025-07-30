package com.scda.backend.api.scheduled;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.vo.ScheduledTriggersDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.quartz.Trigger;
import org.springframework.transaction.annotation.Transactional;

import com.scda.backend.api.scheduled.entity.ScheduledTriggers;

import java.util.List;

/**
* @author 10045
* @description 针对表【scheduled_triggers】的数据库操作Service
* @createDate 2025-07-22 21:03:02
*/
@Transactional(rollbackFor = BusinessException.class)
public interface IScheduledTriggersService extends IService<ScheduledTriggers> {

    void create(ScheduledTriggersCreateDTO req) throws BusinessException;

    Trigger transfer2Trigger(ScheduledTriggersReadDTO req) throws BusinessException;

    List<ScheduledTriggersDetailVO> read(ScheduledTriggersReadDTO req);

    Page<ScheduledTriggersDetailVO> readPage(ScheduledTriggersReadDTO req);

    void update(ScheduledTriggersUpdateDTO req) throws BusinessException;

    void delete(ScheduledTriggersDeleteDTO req) throws BusinessException;
}
