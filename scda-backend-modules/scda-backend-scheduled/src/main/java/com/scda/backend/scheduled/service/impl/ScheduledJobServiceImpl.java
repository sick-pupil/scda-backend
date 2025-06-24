package com.scda.backend.scheduled.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.scheduled.IScheduledJobService;
import com.scda.backend.api.scheduled.dto.ScheduledJobCreateDTO;
import com.scda.backend.api.scheduled.dto.ScheduledJobDeleteDTO;
import com.scda.backend.api.scheduled.dto.ScheduledJobReadDTO;
import com.scda.backend.api.scheduled.dto.ScheduledJobUpdateDTO;
import com.scda.backend.api.scheduled.entity.ScheduledJob;
import com.scda.backend.api.scheduled.enums.JobRunStatusEnum;
import com.scda.backend.api.scheduled.vo.ScheduledJobDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import com.scda.backend.scheduled.mapper.ScheduledJobMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 10045
* @description 针对表【scheduled_job】的数据库操作Service实现
* @createDate 2025-06-23 20:25:38
*/
@Service
public class ScheduledJobServiceImpl extends ServiceImpl<ScheduledJobMapper, ScheduledJob>
    implements IScheduledJobService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void create(ScheduledJobCreateDTO req) throws BusinessException {
        //判断是否存在该class
        Class jobClazz;
        try {
            jobClazz = Class.forName(req.getClassName());
        } catch (ClassNotFoundException ex) {
            throw new BusinessException("不存在" + req.getClassName() + "该类");
        }
        //判断该class是否为jobClass
        if(!Job.class.isAssignableFrom(jobClazz)) {
            throw new BusinessException(req.getClassName() + "该类并非为Job类");
        }

        //job入参
        JobDataMap jobDataMap = new JobDataMap();
        JSONObject jobParam = req.getParams();
        if(jobParam != null && !jobParam.isEmpty()) {
            jobDataMap.putAll(jobParam.to(Map.class));
        }

        //job创建
        JobDetail jobDetail = JobBuilder.newJob()
                .ofType(jobClazz)
                .withIdentity(req.getName(), req.getGroup())
                .withDescription(req.getDesc())
                .storeDurably(Boolean.TRUE)
                .requestRecovery(req.getRecovery())
                .usingJobData(jobDataMap)
                .build();

        //添加job
        try {
            scheduler.addJob(jobDetail, Boolean.FALSE);
        } catch (SchedulerException ex) {
            throw new BusinessException("创建定时任务报错");
        }

        //记录job
        ScheduledJob entity = new ScheduledJob();
        BeanUtils.copyProperties(req, entity);
        entity.setRunStatus(JobRunStatusEnum.NEW.getRunStatus());
        save(entity);
    }

    @Override
    public List<ScheduledJobDetailVO> read(ScheduledJobReadDTO req) {
        LambdaQueryWrapper<ScheduledJob> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(req.getClassName()), ScheduledJob::getClassName, req.getClassName());
        queryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledJob::getName, req.getName());
        queryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledJob::getGroup, req.getGroup());
        queryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledJob::getDesc, req.getDesc());
        queryWrapper.like(ObjectUtils.isNotEmpty(req.getRecovery()), ScheduledJob::getRecovery, req.getRecovery());
        queryWrapper.ge(ObjectUtils.isNotEmpty(req.getStartCreateTime()), ScheduledJob::getCreateTime, req.getStartCreateTime());
        queryWrapper.le(ObjectUtils.isNotEmpty(req.getEndCreateTime()), ScheduledJob::getCreateTime, req.getEndCreateTime());

        List<ScheduledJob> jobList = (List<ScheduledJob>) CollectionUtils.emptyIfNull(list(queryWrapper));
        List<ScheduledJobDetailVO> jobDetailVOList = jobList.stream().map(i -> {
            ScheduledJobDetailVO jobDetailVO = new ScheduledJobDetailVO();
            BeanUtils.copyProperties(i, jobDetailVO);
            return jobDetailVO;
        }).collect(Collectors.toList());
        return jobDetailVOList;
    }

    @Override
    public Page<ScheduledJobDetailVO> readPage(ScheduledJobReadDTO req) {
        LambdaQueryWrapper<ScheduledJob> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(req.getClassName()), ScheduledJob::getClassName, req.getClassName());
        queryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledJob::getName, req.getName());
        queryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledJob::getGroup, req.getGroup());
        queryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledJob::getDesc, req.getDesc());
        queryWrapper.like(ObjectUtils.isNotEmpty(req.getRecovery()), ScheduledJob::getRecovery, req.getRecovery());
        queryWrapper.ge(ObjectUtils.isNotEmpty(req.getStartCreateTime()), ScheduledJob::getCreateTime, req.getStartCreateTime());
        queryWrapper.le(ObjectUtils.isNotEmpty(req.getEndCreateTime()), ScheduledJob::getCreateTime, req.getEndCreateTime());

        Page<ScheduledJob> page = new Page<>(req.getPageQuery().getCurrentPageIndex(), req.getPageQuery().getPageSize());
        Page entityPageRs = page(page, queryWrapper);

        //转vo
        List<ScheduledJob> jobList = entityPageRs.getRecords();
        List<ScheduledJobDetailVO> jobDetailVOList = jobList.stream().map(i -> {
            ScheduledJobDetailVO jobDetailVO = new ScheduledJobDetailVO();
            BeanUtils.copyProperties(i, jobDetailVO);
            return jobDetailVO;
        }).collect(Collectors.toList());

        Page<ScheduledJobDetailVO> voPageRs = new Page<>();
        voPageRs.setRecords(jobDetailVOList);
        voPageRs.setTotal(entityPageRs.getTotal());

        return voPageRs;
    }

    @Override
    public void update(ScheduledJobUpdateDTO req) throws BusinessException {
        //判断job是否存在


        //判断job是否绑定了trigger


        //判断job是否正在运行

    }

    @Override
    public void delete(ScheduledJobDeleteDTO req) throws BusinessException {
        //判断job是否存在
        ScheduledJob job = getById(req.getId());
        if(ObjectUtils.isEmpty(job)) {
            throw new BusinessException("不存在对应定时任务");
        }

        //判断job是否绑定了trigger


        //判断job是否正在运行

    }

    @Override
    public void bindTrigger(ScheduledJobUpdateDTO req) throws BusinessException {

    }

    @Override
    public void start(ScheduledJobUpdateDTO req) throws BusinessException {

    }

    @Override
    public void resume(ScheduledJobUpdateDTO req) throws BusinessException {

    }

    @Override
    public void pause(ScheduledJobUpdateDTO req) throws BusinessException {

    }
}




