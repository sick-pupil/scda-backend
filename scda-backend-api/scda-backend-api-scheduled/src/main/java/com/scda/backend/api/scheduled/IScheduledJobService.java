package com.scda.backend.api.scheduled;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.entity.ScheduledJob;
import com.scda.backend.api.scheduled.vo.ScheduledJobDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 10045
* @description 针对表【scheduled_job】的数据库操作Service
* @createDate 2025-06-23 20:25:38
*/
@Transactional(rollbackFor = RuntimeException.class)
public interface IScheduledJobService extends IService<ScheduledJob> {

    void create(ScheduledJobCreateDTO req) throws BusinessException;

    List<ScheduledJobDetailVO> read(ScheduledJobReadDTO req);

    Page<ScheduledJobDetailVO> readPage(ScheduledJobReadDTO req);

    void update(ScheduledJobUpdateDTO req) throws BusinessException;

    void delete(ScheduledJobDeleteDTO req) throws BusinessException;

    void bindTrigger(ScheduledJobUpdateDTO req) throws BusinessException;

    void start(ScheduledJobUpdateDTO req) throws BusinessException;

    void resume(ScheduledJobUpdateDTO req) throws BusinessException;

    void pause(ScheduledJobUpdateDTO req) throws BusinessException;
}
