package com.scda.backend.api.scheduled.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ApiModel(value="ScheduledTriggers对象", description="")
@Data
@TableName("scheduled_triggers")
/**
* 
* @TableName scheduled_triggers
*/
public class ScheduledTriggers extends Model<ScheduledTriggers> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * trigger名称
    */
    @ApiModelProperty("trigger名称")
    @TableField("name")
    private String name;

    /**
    * 组名称
    */
    @ApiModelProperty("组名称")
    @TableField("group")
    private String group;

    /**
    * 描述
    */
    @ApiModelProperty("描述")
    @TableField("desc")
    private String desc;

    /**
    * 是否立即执行一次
    */
    @ApiModelProperty("是否立即执行一次")
    @TableField("start_now")
    private Boolean startNow;

    /**
     * 开始时刻
     */
    @ApiModelProperty("开始时刻")
    @TableField("start_at")
    private LocalDateTime startAt;

    /**
    * 结束时刻
    */
    @ApiModelProperty("结束时刻")
    @TableField("end_at")
    private LocalDateTime endAt;

    /**
    * 入参
    */
    @ApiModelProperty("入参")
    @TableField(value = "params", typeHandler = FastjsonTypeHandler.class)
    private JSONObject params;

    /**
    * 调度类型，0简单，1cron，2日历，3每日
    */
    @ApiModelProperty("调度类型，0简单，1cron，2日历，3每日")
    @TableField("schedule_type")
    private Integer scheduleType;

    /**
    * 简单调度，间隔秒
    */
    @ApiModelProperty("简单调度，间隔秒")
    @TableField("simple_interval_seconds")
    private Integer simpleIntervalSeconds;

    /**
    * 简单调度，间隔分钟
    */
    @ApiModelProperty("简单调度，间隔分钟")
    @TableField("simple_interval_minutes")
    private Integer simpleIntervalMinutes;

    /**
    * 简单调度，间隔小时
    */
    @ApiModelProperty("简单调度，间隔小时")
    @TableField("simple_interval_hours")
    private Integer simpleIntervalHours;

    /**
    * 简单调度，重复次数
    */
    @ApiModelProperty("简单调度，重复次数")
    @TableField("simple_repeat_count")
    private Integer simpleRepeatCount;

    /**
    * 简单调度，是否永远重复
    */
    @ApiModelProperty("简单调度，是否永远重复")
    @TableField("simple_repeat_forever")
    private Boolean simpleRepeatForever;

    /**
    * cron调度，cron表达式
    */
    @ApiModelProperty("cron调度，cron表达式")
    @TableField("cron_expression")
    private String cronExpression;

    /**
    * 日历调度，间隔天
    */
    @ApiModelProperty("日历调度，间隔天")
    @TableField("calendar_interval_days")
    private Integer calendarIntervalDays;

    /**
    * 日历调度，间隔周
    */
    @ApiModelProperty("日历调度，间隔周")
    @TableField("calendar_interval_weeks")
    private Integer calendarIntervalWeeks;

    /**
    * 日历调度，间隔月
    */
    @ApiModelProperty("日历调度，间隔月")
    @TableField("calendar_interval_months")
    private Integer calendarIntervalMonths;

    /**
    * 日历调度，间隔年
    */
    @ApiModelProperty("日历调度，间隔年")
    @TableField("calendar_interval_years")
    private Integer calendarIntervalYears;

    /**
    * 每日调度，开始时刻
    */
    @ApiModelProperty("每日调度，开始时刻")
    @TableField("daily_start_at")
    private LocalTime dailyStartAt;

    /**
    * 每日调度，结束时刻
    */
    @ApiModelProperty("每日调度，结束时刻")
    @TableField("daily_end_at")
    private LocalTime dailyEndAt;

    /**
    * 每日调度，间隔秒
    */
    @ApiModelProperty("每日调度，间隔秒")
    @TableField("daily_interval_seconds")
    private Integer dailyIntervalSeconds;

    /**
    * 每日调度，一周中的哪天
    */
    @ApiModelProperty("每日调度，一周中的哪天")
    @TableField("daily_on_day_of_week")
    private Integer dailyOnDayOfWeek;

    /**
    * 每日调度，是否每天调度
    */
    @ApiModelProperty("每日调度，是否每天调度")
    @TableField("daily_every_day")
    private Boolean dailyEveryDay;

    /**
    * 每日调度，是否周一到周五调度
    */
    @ApiModelProperty("每日调度，是否周一到周五调度")
    @TableField("daily_mon_to_fri")
    private Boolean dailyMonToFri;

    /**
    * 每日调度，是否周六到周日调度
    */
    @ApiModelProperty("每日调度，是否周六到周日调度")
    @TableField("daily_sat_to_sun")
    private Boolean dailySatToSun;

    /**
    * 每日调度，每天重复次数
    */
    @ApiModelProperty("每日调度，每天重复次数")
    @TableField("daily_repeat_count")
    private Integer dailyRepeatCount;

    /**
    * 是否被删除
    */
    @ApiModelProperty("是否被删除")
    @TableLogic
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;

    /**
    * 创建者
    */
    @ApiModelProperty("创建者")
    @TableField(value = "creator_user_id", fill = FieldFill.INSERT)
    private Long creatorUserId;

    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
    * 更新者
    */
    @ApiModelProperty("更新者")
    @TableField(value = "updator_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updatorUserId;

    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
    * 版本号
    */
    @ApiModelProperty("版本号")
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;

    /**
    * 租户id
    */
    @ApiModelProperty("租户id")
    @TableField(value = "tenant_id", fill = FieldFill.INSERT)
    private Long tenantId;


}
