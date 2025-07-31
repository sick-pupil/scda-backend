package com.scda.backend.scheduled.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scda.backend.api.scheduled.IScheduledJobsService;
import com.scda.backend.api.scheduled.IScheduledRelJobTriggerService;
import com.scda.backend.api.scheduled.dto.*;
import com.scda.backend.api.scheduled.entity.ScheduledJobs;
import com.scda.backend.api.scheduled.entity.ScheduledRelJobTrigger;
import com.scda.backend.api.scheduled.enums.ScheduleTypeEnum;
import com.scda.backend.api.scheduled.vo.ScheduledJobsDetailVO;
import com.scda.backend.api.scheduled.vo.ScheduledTriggersDetailVO;
import com.scda.backend.common.core.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scda.backend.api.scheduled.entity.ScheduledTriggers;
import com.scda.backend.api.scheduled.IScheduledTriggersService;
import com.scda.backend.scheduled.mapper.ScheduledTriggersMapper;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author 10045
* @description 针对表【scheduled_triggers】的数据库操作Service实现
* @createDate 2025-07-22 21:03:02
*/
@Service
public class ScheduledTriggersServiceImpl extends ServiceImpl<ScheduledTriggersMapper, ScheduledTriggers>
    implements IScheduledTriggersService {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private IScheduledRelJobTriggerService relJobTriggerService;

    @Autowired
    private IScheduledJobsService jobsService;

    @Override
    public void create(ScheduledTriggersCreateDTO req) throws BusinessException {
        //简单调度
        if(req.getScheduleType().compareTo(ScheduleTypeEnum.SIMPLE.getType()) == 0) {
            List<Integer> intervalTimeArgsList = Arrays.asList(req.getSimpleIntervalSeconds(),
                    req.getSimpleIntervalMinutes(),
                    req.getSimpleIntervalHours());
            Integer notNullintervalTimeArgsCount = (int) intervalTimeArgsList.stream().filter(ObjectUtils::isNotEmpty).count();
            if(notNullintervalTimeArgsCount.compareTo(0) == 0 || notNullintervalTimeArgsCount.compareTo(1) > 0) {
                throw new BusinessException("间隔时间必填且必填一个");
            }
        }
        //cron调度
        else if(req.getScheduleType().compareTo(ScheduleTypeEnum.CRON.getType()) == 0) {
            if(StringUtils.isBlank(req.getCronExpression())) {
                throw new BusinessException("cron表达式必填");
            }
        }
        //calendar日历调度
        else if(req.getScheduleType().compareTo(ScheduleTypeEnum.CALENDAR.getType()) == 0) {
            List<Integer> intervalTimeArgsList = Arrays.asList(req.getCalendarIntervalDays(),
                    req.getCalendarIntervalWeeks(),
                    req.getCalendarIntervalMonths(),
                    req.getCalendarIntervalYears());
            Integer notNullintervalTimeArgsCount = (int) intervalTimeArgsList.stream().filter(ObjectUtils::isNotEmpty).count();
            if(notNullintervalTimeArgsCount.compareTo(0) == 0 || notNullintervalTimeArgsCount.compareTo(1) > 0) {
                throw new BusinessException("间隔时间必填且必填一个");
            }
        }
        //daily每日调度
        else if(req.getScheduleType().compareTo(ScheduleTypeEnum.DAILY.getType()) == 0) {
            if(!ObjectUtils.allNull(req.getDailyStartAt(), req.getDailyEndAt())
                    && !ObjectUtils.allNotNull(req.getDailyStartAt(), req.getDailyEndAt())) {
                throw new BusinessException("开始与结束时间范围均必填");
            }
            if(ObjectUtils.isEmpty(req.getDailyIntervalSeconds())) {
                throw new BusinessException("间隔时间必填");
            }

            List<Object> dayTimeRangeArgsList = Arrays.asList(req.getDailyOnDayOfWeek(),
                    req.getDailyEveryDay(),
                    req.getDailyMonToFri(),
                    req.getDailySatToSun());
            Integer notNullDayTimeRangeArgsCount = (int) dayTimeRangeArgsList.stream().filter(ObjectUtils::isNotEmpty).count();
            if(notNullDayTimeRangeArgsCount.compareTo(0) == 0 || notNullDayTimeRangeArgsCount.compareTo(1) > 0) {
                throw new BusinessException("周内天区间范围必填且必填一个");
            }
        }
        else {
            throw new BusinessException("不存在该调度类型");
        }

        ScheduledTriggers triggers = new ScheduledTriggers();
        BeanUtils.copyProperties(req, triggers);
        save(triggers);
    }

    @Override
    public Trigger transfer2Trigger(ScheduledTriggersReadDTO req) throws BusinessException {
        if(ObjectUtils.isEmpty(req.getId())) {
            throw new BusinessException("id非空");
        }
        ScheduledTriggers triggers = getById(req.getId());

        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger()
                .withIdentity(triggers.getName(), triggers.getGroup())
                .withDescription(triggers.getDesc())
                .startAt(Date.from(triggers.getStartAt().atZone(ZoneId.systemDefault()).toInstant()))
                .endAt(Date.from(triggers.getEndAt().atZone(ZoneId.systemDefault()).toInstant()));

        if(req.getStartNow()) {
            triggerBuilder = triggerBuilder.startNow();
        }
        if(ObjectUtils.isNotEmpty(triggers.getParams())) {
            JobDataMap jobDataMap = new JobDataMap();
            JSONObject jobParam = triggers.getParams();
            if(jobParam != null && !jobParam.isEmpty()) {
                jobDataMap.putAll(jobParam.to(Map.class));
            }
            triggerBuilder = triggerBuilder.usingJobData(jobDataMap);
        }

        //简单调度
        if(triggers.getScheduleType().compareTo(ScheduleTypeEnum.SIMPLE.getType()) == 0) {
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();

            if(ObjectUtils.isNotEmpty(triggers.getSimpleIntervalSeconds())) {
                simpleScheduleBuilder = simpleScheduleBuilder.withIntervalInSeconds(triggers.getSimpleIntervalSeconds());
            } else if(ObjectUtils.isNotEmpty(triggers.getSimpleIntervalMinutes())) {
                simpleScheduleBuilder = simpleScheduleBuilder.withIntervalInMinutes(triggers.getSimpleIntervalMinutes());
            } else if(ObjectUtils.isNotEmpty(triggers.getSimpleIntervalHours())) {
                simpleScheduleBuilder = simpleScheduleBuilder.withIntervalInMinutes(triggers.getSimpleIntervalHours());
            }

            if(ObjectUtils.isNotEmpty(triggers.getSimpleRepeatCount())) {
                simpleScheduleBuilder = simpleScheduleBuilder.withRepeatCount(triggers.getSimpleRepeatCount());
            }
            if(triggers.getSimpleRepeatForever()) {
                simpleScheduleBuilder.repeatForever();
            }

            triggerBuilder.withSchedule(simpleScheduleBuilder);
        }
        //cron调度
        else if(triggers.getScheduleType().compareTo(ScheduleTypeEnum.CRON.getType()) == 0) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(triggers.getCronExpression());
            triggerBuilder.withSchedule(cronScheduleBuilder);
        }
        //calendar日历调度
        else if(triggers.getScheduleType().compareTo(ScheduleTypeEnum.CALENDAR.getType()) == 0) {
            CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder = CalendarIntervalScheduleBuilder.calendarIntervalSchedule();

            if(ObjectUtils.isNotEmpty(triggers.getCalendarIntervalDays())) {
                calendarIntervalScheduleBuilder = calendarIntervalScheduleBuilder.withIntervalInDays(triggers.getCalendarIntervalDays());
            } else if(ObjectUtils.isNotEmpty(triggers.getCalendarIntervalWeeks())) {
                calendarIntervalScheduleBuilder = calendarIntervalScheduleBuilder.withIntervalInWeeks(triggers.getCalendarIntervalWeeks());
            } else if(ObjectUtils.isNotEmpty(triggers.getCalendarIntervalMonths())) {
                calendarIntervalScheduleBuilder = calendarIntervalScheduleBuilder.withIntervalInMonths(triggers.getCalendarIntervalMonths());
            } else if(ObjectUtils.isNotEmpty(triggers.getCalendarIntervalYears())) {
                calendarIntervalScheduleBuilder = calendarIntervalScheduleBuilder.withIntervalInYears(triggers.getCalendarIntervalYears());
            }

            triggerBuilder.withSchedule(calendarIntervalScheduleBuilder);
        }
        //daily每日调度
        else if(triggers.getScheduleType().compareTo(ScheduleTypeEnum.DAILY.getType()) == 0) {
            DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule();

            if(ObjectUtils.isNotEmpty(triggers.getDailyStartAt())) {
                LocalTime startAtLocalTime = triggers.getDailyStartAt();
                TimeOfDay startAtTimeOfDay = new TimeOfDay(
                    startAtLocalTime.getHour(),
                    startAtLocalTime.getMinute(),
                    startAtLocalTime.getSecond()
                );
                dailyTimeIntervalScheduleBuilder.startingDailyAt(startAtTimeOfDay);
            }
            if(ObjectUtils.isNotEmpty(triggers.getDailyEndAt())) {
                LocalTime endAtLocalTime = triggers.getDailyEndAt();
                TimeOfDay endAtTimeOfDay = new TimeOfDay(
                    endAtLocalTime.getHour(),
                    endAtLocalTime.getMinute(),
                    endAtLocalTime.getSecond()
                );
                dailyTimeIntervalScheduleBuilder.endingDailyAt(endAtTimeOfDay);
            }

            if(ObjectUtils.isNotEmpty(triggers.getDailyIntervalSeconds())) {
                dailyTimeIntervalScheduleBuilder.withIntervalInSeconds(triggers.getDailyIntervalSeconds());
            }

            if(ObjectUtils.isNotEmpty(triggers.getDailyOnDayOfWeek())) {
                dailyTimeIntervalScheduleBuilder.onDaysOfTheWeek(triggers.getDailyOnDayOfWeek());
            } else if(triggers.getDailyEveryDay()) {
                dailyTimeIntervalScheduleBuilder.onEveryDay();
            } else if(triggers.getDailyMonToFri()) {
                dailyTimeIntervalScheduleBuilder.onMondayThroughFriday();
            } else if(triggers.getDailySatToSun()) {
                dailyTimeIntervalScheduleBuilder.onSaturdayAndSunday();
            }

            if(ObjectUtils.isNotEmpty(triggers.getDailyRepeatCount())) {
                dailyTimeIntervalScheduleBuilder.withRepeatCount(triggers.getDailyRepeatCount());
            }

            triggerBuilder.withSchedule(dailyTimeIntervalScheduleBuilder);
        }
        else {
            throw new BusinessException("不存在该调度类型");
        }

        return triggerBuilder.build();
    }

    @Override
    public List<ScheduledTriggersDetailVO> read(ScheduledTriggersReadDTO req) {
        LambdaQueryWrapper<ScheduledTriggers> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(ScheduledTriggers::getScheduleType, req.getScheduleType());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledTriggers::getGroup, req.getGroup());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledTriggers::getName, req.getName());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledTriggers::getDesc, req.getDesc());
        lambdaQueryWrapper.between(
                ObjectUtils.isNotEmpty(req.getStartStartEndAt()) && ObjectUtils.isNotEmpty(req.getEndStartEndAt()),
                ScheduledTriggers::getStartAt,
                req.getStartStartEndAt(),
                req.getEndStartEndAt()
        );
        lambdaQueryWrapper.between(
                ObjectUtils.isNotEmpty(req.getStartStartEndAt()) && ObjectUtils.isNotEmpty(req.getEndStartEndAt()),
                ScheduledTriggers::getEndAt,
                req.getStartStartEndAt(),
                req.getEndStartEndAt()
        );
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getScheduleType()), ScheduledTriggers::getScheduleType, req.getScheduleType());

        List<ScheduledTriggers> triggerList = (List<ScheduledTriggers>) CollectionUtils.emptyIfNull(list(lambdaQueryWrapper));
        List<ScheduledTriggersDetailVO> triggersDetailVOList = triggerList.stream().map(i -> {
            ScheduledTriggersDetailVO triggersDetailVO = new ScheduledTriggersDetailVO();
            BeanUtils.copyProperties(i, triggersDetailVO);
            return triggersDetailVO;
        }).collect(Collectors.toList());
        return triggersDetailVOList;
    }

    @Override
    public Page<ScheduledTriggersDetailVO> readPage(ScheduledTriggersReadDTO req) {
        LambdaQueryWrapper<ScheduledTriggers> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.eq(ScheduledTriggers::getScheduleType, req.getScheduleType());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getGroup()), ScheduledTriggers::getGroup, req.getGroup());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getName()), ScheduledTriggers::getName, req.getName());
        lambdaQueryWrapper.like(StringUtils.isNotBlank(req.getDesc()), ScheduledTriggers::getDesc, req.getDesc());
        lambdaQueryWrapper.between(
                ObjectUtils.isNotEmpty(req.getStartStartEndAt()) && ObjectUtils.isNotEmpty(req.getEndStartEndAt()),
                ScheduledTriggers::getStartAt,
                req.getStartStartEndAt(),
                req.getEndStartEndAt()
        );
        lambdaQueryWrapper.between(
                ObjectUtils.isNotEmpty(req.getStartStartEndAt()) && ObjectUtils.isNotEmpty(req.getEndStartEndAt()),
                ScheduledTriggers::getEndAt,
                req.getStartStartEndAt(),
                req.getEndStartEndAt()
        );
        lambdaQueryWrapper.eq(ObjectUtils.isNotEmpty(req.getScheduleType()), ScheduledTriggers::getScheduleType, req.getScheduleType());

        Page<ScheduledTriggers> page = new Page<>(req.getPageQuery().getCurrentPageIndex(), req.getPageQuery().getPageSize());
        Page entityPageRs = page(page, lambdaQueryWrapper);

        //转vo
        List<ScheduledTriggers> triggerList = (List<ScheduledTriggers>) CollectionUtils.emptyIfNull(list(lambdaQueryWrapper));
        List<ScheduledTriggersDetailVO> triggersDetailVOList = triggerList.stream().map(i -> {
            ScheduledTriggersDetailVO triggersDetailVO = new ScheduledTriggersDetailVO();
            BeanUtils.copyProperties(i, triggersDetailVO);
            return triggersDetailVO;
        }).collect(Collectors.toList());

        Page<ScheduledTriggersDetailVO> voPageRs = new Page<>();
        voPageRs.setRecords(triggersDetailVOList);
        voPageRs.setTotal(entityPageRs.getTotal());

        return voPageRs;
    }

    @Override
    public void update(ScheduledTriggersUpdateDTO req) throws BusinessException {
        ScheduledTriggers trigger = getById(req.getId());
        if(ObjectUtils.isEmpty(trigger)) {
            throw new BusinessException("不存在该定时任务触发器");
        }

        //trigger是否绑定了job，未绑定则直接更新


        //trigger是否绑定了job，绑定了则暂停job并解绑，更新trigger再重新绑定
    }

    @Override
    public void delete(ScheduledTriggersDeleteDTO req) throws BusinessException {
        ScheduledTriggers trigger = getById(req.getId());
        if(ObjectUtils.isEmpty(trigger)) {
            throw new BusinessException("不存在该定时任务触发器");
        }

        //trigger是否绑定了job，未绑定则直接删除

        //trigger是否绑定了job，绑定了则暂停job并解绑，删除trigger
    }
}




