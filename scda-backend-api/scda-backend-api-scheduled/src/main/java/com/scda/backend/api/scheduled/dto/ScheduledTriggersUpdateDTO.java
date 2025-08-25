package com.scda.backend.api.scheduled.dto;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ApiModel("更新定时任务触发器DTO")
@Data
public class ScheduledTriggersUpdateDTO implements Serializable {

    private static final long serialVersionUID = -7813131474166022274L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;


    /**
     * trigger名称
     */
    @ApiModelProperty("trigger名称")
    private String name;

    /**
     * 组名称
     */
    @ApiModelProperty("组名称")
    private String group;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String desc;

    /**
     * 是否立即执行一次
     */
    @ApiModelProperty("是否立即执行一次")
    private Boolean startNow;

    /**
     * 开始时刻
     */
    @ApiModelProperty("开始时刻")
    private LocalDateTime startAt;

    /**
     * 结束时刻
     */
    @ApiModelProperty("结束时刻")
    private LocalDateTime endAt;

    /**
     * 入参
     */
    @ApiModelProperty("入参")
    private JSONObject params;

    /**
     * 调度类型，0简单，1cron，2日历，3每日
     */
    @ApiModelProperty("调度类型，0简单，1cron，2日历，3每日")
    private Integer scheduleType;

    /**
     * 简单调度，间隔秒
     */
    @ApiModelProperty("简单调度，间隔秒")
    private Integer simpleIntervalSeconds;

    /**
     * 简单调度，间隔分钟
     */
    @ApiModelProperty("简单调度，间隔分钟")
    private Integer simpleIntervalMinutes;

    /**
     * 简单调度，间隔小时
     */
    @ApiModelProperty("简单调度，间隔小时")
    private Integer simpleIntervalHours;

    /**
     * 简单调度，重复次数
     */
    @ApiModelProperty("简单调度，重复次数")
    private Integer simpleRepeatCount;

    /**
     * 简单调度，是否永远重复
     */
    @ApiModelProperty("简单调度，是否永远重复")
    private Boolean simpleRepeatForever;

    /**
     * cron调度，cron表达式
     */
    @ApiModelProperty("cron调度，cron表达式")
    private String cronExpression;

    /**
     * 日历调度，间隔天
     */
    @ApiModelProperty("日历调度，间隔天")
    private Integer calendarIntervalDays;

    /**
     * 日历调度，间隔周
     */
    @ApiModelProperty("日历调度，间隔周")
    private Integer calendarIntervalWeeks;

    /**
     * 日历调度，间隔月
     */
    @ApiModelProperty("日历调度，间隔月")
    private Integer calendarIntervalMonths;

    /**
     * 日历调度，间隔年
     */
    @ApiModelProperty("日历调度，间隔年")
    private Integer calendarIntervalYears;

    /**
     * 每日调度，开始时刻
     */
    @ApiModelProperty("每日调度，开始时刻")
    private LocalTime dailyStartAt;

    /**
     * 每日调度，结束时刻
     */
    @ApiModelProperty("每日调度，结束时刻")
    private LocalTime dailyEndAt;

    /**
     * 每日调度，间隔秒
     */
    @ApiModelProperty("每日调度，间隔秒")
    private Integer dailyIntervalSeconds;

    /**
     * 每日调度，一周中的哪天
     */
    @ApiModelProperty("每日调度，一周中的哪天")
    private Integer dailyOnDayOfWeek;

    /**
     * 每日调度，是否每天调度
     */
    @ApiModelProperty("每日调度，是否每天调度")
    private Boolean dailyEveryDay;

    /**
     * 每日调度，是否周一到周五调度
     */
    @ApiModelProperty("每日调度，是否周一到周五调度")
    private Boolean dailyMonToFri;

    /**
     * 每日调度，是否周六到周日调度
     */
    @ApiModelProperty("每日调度，是否周六到周日调度")
    private Boolean dailySatToSun;

    /**
     * 每日调度，每天重复次数
     */
    @ApiModelProperty("每日调度，每天重复次数")
    private Integer dailyRepeatCount;
}
