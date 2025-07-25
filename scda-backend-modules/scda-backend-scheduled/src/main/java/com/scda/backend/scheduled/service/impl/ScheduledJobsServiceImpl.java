package com.scda.backend.scheduled.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.scheduled.IScheduledJobsService;
import com.scda.backend.api.scheduled.IScheduledRelJobTriggerService;
import com.scda.backend.api.scheduled.IScheduledTriggersService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.entity.ScheduledJobs;
import com.scda.backend.api.scheduled.entity.ScheduledRelJobTrigger;
import com.scda.backend.api.scheduled.entity.ScheduledTriggers;
import com.scda.backend.api.scheduled.enums.JobRunStatusEnum;
import com.scda.backend.api.scheduled.vo.ScheduledJobsDetailVO;
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
public class ScheduledJobsServiceImpl extends ServiceImpl<ScheduledJobMapper, ScheduledJobs>
    implements IScheduledJobsService {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private IScheduledTriggersService triggersService;

    @Autowired
    private IScheduledRelJobTriggerService relJobTriggerService;

    @Override
    public void create(ScheduledJobsCreateDTO req) throws BusinessException {
        //判断是否重复
        ScheduledJobsReadDTO readDTO = new ScheduledJobsReadDTO();
        Boolean isExists = checkExists(readDTO);
        if(isExists) {
            throw new BusinessException("已存在重复job");
        }

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
        ScheduledJobs entity = new ScheduledJobs();
        BeanUtils.copyProperties(req, entity);
        entity.setRunStatus(JobRunStatusEnum.NEW.getRunStatus());
        save(entity);
    }

    @Override
    public List<ScheduledJobsDetailVO> read(ScheduledJobsReadDTO req) {
        LambdaQueryWrapper<ScheduledJobs> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(req.getClassName()), ScheduledJobs::getClassName, req.getClassName());
        queryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledJobs::getName, req.getName());
        queryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledJobs::getGroup, req.getGroup());
        queryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledJobs::getDesc, req.getDesc());
        queryWrapper.like(ObjectUtils.isNotEmpty(req.getRecovery()), ScheduledJobs::getRecovery, req.getRecovery());
        queryWrapper.ge(ObjectUtils.isNotEmpty(req.getStartCreateTime()), ScheduledJobs::getCreateTime, req.getStartCreateTime());
        queryWrapper.le(ObjectUtils.isNotEmpty(req.getEndCreateTime()), ScheduledJobs::getCreateTime, req.getEndCreateTime());
        queryWrapper.eq(ObjectUtils.isNotEmpty(req.getRunStatus()), ScheduledJobs::getRunStatus, req.getRunStatus());

        List<ScheduledJobs> jobList = (List<ScheduledJobs>) CollectionUtils.emptyIfNull(list(queryWrapper));
        List<ScheduledJobsDetailVO> jobDetailVOList = jobList.stream().map(i -> {
            ScheduledJobsDetailVO jobDetailVO = new ScheduledJobsDetailVO();
            BeanUtils.copyProperties(i, jobDetailVO);
            return jobDetailVO;
        }).collect(Collectors.toList());
        return jobDetailVOList;
    }

    @Override
    public Page<ScheduledJobsDetailVO> readPage(ScheduledJobsReadDTO req) {
        LambdaQueryWrapper<ScheduledJobs> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StringUtils.isNotBlank(req.getClassName()), ScheduledJobs::getClassName, req.getClassName());
        queryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledJobs::getName, req.getName());
        queryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledJobs::getGroup, req.getGroup());
        queryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledJobs::getDesc, req.getDesc());
        queryWrapper.like(ObjectUtils.isNotEmpty(req.getRecovery()), ScheduledJobs::getRecovery, req.getRecovery());
        queryWrapper.ge(ObjectUtils.isNotEmpty(req.getStartCreateTime()), ScheduledJobs::getCreateTime, req.getStartCreateTime());
        queryWrapper.le(ObjectUtils.isNotEmpty(req.getEndCreateTime()), ScheduledJobs::getCreateTime, req.getEndCreateTime());
        queryWrapper.eq(ObjectUtils.isNotEmpty(req.getRunStatus()), ScheduledJobs::getRunStatus, req.getRunStatus());

        Page<ScheduledJobs> page = new Page<>(req.getPageQuery().getCurrentPageIndex(), req.getPageQuery().getPageSize());
        Page entityPageRs = page(page, queryWrapper);

        //转vo
        List<ScheduledJobs> jobList = entityPageRs.getRecords();
        List<ScheduledJobsDetailVO> jobDetailVOList = jobList.stream().map(i -> {
            ScheduledJobsDetailVO jobDetailVO = new ScheduledJobsDetailVO();
            BeanUtils.copyProperties(i, jobDetailVO);
            return jobDetailVO;
        }).collect(Collectors.toList());

        Page<ScheduledJobsDetailVO> voPageRs = new Page<>();
        voPageRs.setRecords(jobDetailVOList);
        voPageRs.setTotal(entityPageRs.getTotal());

        return voPageRs;
    }

    @Override
    public Boolean checkExists(ScheduledJobsReadDTO req) throws BusinessException {
        if(StringUtils.isBlank(req.getGroup()) || StringUtils.isBlank(req.getName())) {
            throw new BusinessException("组名称或名称非空");
        }

        //判断job是否存在表中以及scheduler中
        Boolean isTbExists = Boolean.FALSE, isSchedulerJobExists = Boolean.FALSE;
        LambdaQueryWrapper<ScheduledJobs> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(ScheduledJobs::getGroup, req.getGroup());
        queryWrapper.eq(ScheduledJobs::getName, req.getName());
        isTbExists = this.baseMapper.exists(queryWrapper);

        try {
            isSchedulerJobExists = scheduler.checkExists(new JobKey(req.getName(), req.getGroup()));
        } catch (SchedulerException ex) {
            throw new BusinessException(ex.getMessage());
        }

        if(isTbExists || isSchedulerJobExists) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public void update(ScheduledJobsUpdateDTO req) throws BusinessException {
        //获取job记录
        ScheduledJobs job = getById(req.getId());
        if(ObjectUtils.isEmpty(job)) {
            throw new BusinessException("不存在该job");
        }
        if(StringUtils.isBlank(job.getGroup()) || StringUtils.isBlank(job.getName())) {
            throw new BusinessException("该job配置不完整");
        }

        //判断job是否存在
        ScheduledJobsReadDTO readDTO = new ScheduledJobsReadDTO();
        BeanUtils.copyProperties(req, readDTO);
        Boolean isExists = checkExists(readDTO);
        if(!isExists) {
            throw new BusinessException("该job并不存在");
        }

        //判断job是否正在运行，运行则暂停
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            for(JobExecutionContext context : executingJobs) {
                JobKey key = context.getJobDetail().getKey();
                if (key.getName().equals(job.getName()) && key.getGroup().equals(job.getGroup())) {
                    scheduler.pauseJob(new JobKey(job.getName(), job.getGroup()));
                    break;
                }
            }
        } catch (SchedulerException ex) {
            throw new BusinessException(ex.getMessage());
        }

        //覆盖job
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
            scheduler.addJob(jobDetail, Boolean.TRUE);
        } catch (SchedulerException ex) {
            throw new BusinessException("创建定时任务报错");
        }

        //记录job
        ScheduledJobs entity = new ScheduledJobs();
        BeanUtils.copyProperties(req, entity);
        entity.setRunStatus(JobRunStatusEnum.NEW.getRunStatus());
        updateById(entity);
    }

    @Override
    public void delete(ScheduledJobsDeleteDTO req) throws BusinessException {
        //获取job记录
        ScheduledJobs job = getById(req.getId());
        if(ObjectUtils.isEmpty(job)) {
            throw new BusinessException("不存在该job");
        }
        if(StringUtils.isBlank(job.getGroup()) || StringUtils.isBlank(job.getName())) {
            throw new BusinessException("该job配置不完整");
        }

        //判断job是否存在
        ScheduledJobsReadDTO readDTO = new ScheduledJobsReadDTO();
        BeanUtils.copyProperties(req, readDTO);
        Boolean isExists = checkExists(readDTO);
        if(!isExists) {
            throw new BusinessException("该job并不存在");
        }

        //判断job是否正在运行，运行则暂停
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            for(JobExecutionContext context : executingJobs) {
                JobKey key = context.getJobDetail().getKey();
                if (key.getName().equals(job.getName()) && key.getGroup().equals(job.getGroup())) {
                    scheduler.pauseJob(new JobKey(job.getName(), job.getGroup()));
                }
            }
        } catch (SchedulerException ex) {
            throw new BusinessException(ex.getMessage());
        }

        //删除job以及关联trigger
        try {
            scheduler.deleteJob(new JobKey(job.getName(), job.getGroup()));
        } catch (SchedulerException ex) {
            throw new BusinessException(ex.getMessage());
        }
        //删除trigger记录
        List<ScheduledRelJobTrigger> relJobTriggerList = relJobTriggerService.getRelsByJobId(job.getId());
        if(CollectionUtils.isNotEmpty(relJobTriggerList)) {
            relJobTriggerService.removeBatchByIds(relJobTriggerList.stream().map(ScheduledRelJobTrigger::getId).collect(Collectors.toList()));
            List<Long> triggerIdList = relJobTriggerList.stream().map(ScheduledRelJobTrigger::getTriggerId).distinct().collect(Collectors.toList());
            triggersService.removeBatchByIds(triggerIdList);
        }
        //删除job记录
        removeById(job.getId());
    }

    @Override
    public void bindTrigger(ScheduledJobsUpdateDTO req) throws BusinessException {
        //判断job和trigger是否都存在
        ScheduledTriggersUpdateDTO bindTrigger = req.getBindTrigger();
        ScheduledTriggers trigger;
        if(ObjectUtils.isEmpty(bindTrigger)) {
            throw new BusinessException("不存在该trigger");
        } else {
            trigger = triggersService.getById(bindTrigger.getId());
            if(ObjectUtils.isEmpty(trigger)) {
                throw new BusinessException("不存在该trigger");
            }
        }
        ScheduledJobs job = getById(req.getId());
        if(ObjectUtils.isEmpty(job)) {
            throw new BusinessException("不存在该job");
        }

        //检查是否存在绑定关系
        ScheduledRelJobTrigger relJobTrigger = relJobTriggerService.getRelsByJobIdTriggerId(job.getId(), trigger.getId());
        Boolean isExistsBindingTrigger = Boolean.FALSE;
        JobKey jobKey = new JobKey(job.getName(), job.getGroup());
        try {
            TriggerKey triggerKey = new TriggerKey(trigger.getName(), trigger.getGroup());
            List<? extends Trigger> bindingTriggersByJob = scheduler.getTriggersOfJob(jobKey);
            for(Trigger bindingTrigger : bindingTriggersByJob) {
                if(triggerKey.equals(bindingTrigger.getKey())) {
                    isExistsBindingTrigger = Boolean.TRUE;
                    break;
                }
            }
        } catch (SchedulerException ex) {
            throw new BusinessException(ex.getMessage());
        }

        //绑定job与trigger
        if(ObjectUtils.isNotEmpty(relJobTrigger) || isExistsBindingTrigger) {
            throw new BusinessException("已绑定该job与trigger");
        } else {
            //建立关联关系
            ScheduledRelJobTrigger insertRelJobTrigger = new ScheduledRelJobTrigger();
            insertRelJobTrigger.setJobId(job.getId());
            insertRelJobTrigger.setTriggerId(trigger.getId());
            relJobTriggerService.save(insertRelJobTrigger);

            //创建quartz中的trigger并绑定job
        }
    }

    @Override
    public void start(ScheduledJobsUpdateDTO req) throws BusinessException {

    }

    @Override
    public void resume(ScheduledJobsUpdateDTO req) throws BusinessException {

    }

    @Override
    public void pause(ScheduledJobsUpdateDTO req) throws BusinessException {

    }
}




