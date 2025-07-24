package com.scda.backend.api.scheduled;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.entity.ScheduledJobs;
import com.scda.backend.api.scheduled.vo.ScheduledJobsDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 10045
* @description 针对表【scheduled_job】的数据库操作Service
* @createDate 2025-06-23 20:25:38
*/
@Transactional(rollbackFor = BusinessException.class)
public interface IScheduledJobsService extends IService<ScheduledJobs> {

    void create(ScheduledJobsCreateDTO req) throws BusinessException;

    List<ScheduledJobsDetailVO> read(ScheduledJobsReadDTO req);

    Page<ScheduledJobsDetailVO> readPage(ScheduledJobsReadDTO req);

    Boolean checkExists(ScheduledJobsReadDTO req) throws BusinessException;

    void update(ScheduledJobsUpdateDTO req) throws BusinessException;

    void delete(ScheduledJobsDeleteDTO req) throws BusinessException;

    void bindTrigger(ScheduledJobsUpdateDTO req) throws BusinessException;

    void start(ScheduledJobsUpdateDTO req) throws BusinessException;

    void resume(ScheduledJobsUpdateDTO req) throws BusinessException;

    void pause(ScheduledJobsUpdateDTO req) throws BusinessException;
}
