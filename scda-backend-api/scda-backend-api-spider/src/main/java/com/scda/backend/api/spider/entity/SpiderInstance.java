package com.scda.backend.api.spider.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value="SpiderInstance对象", description="抓取实例")
@Data
@TableName("spider_instance")
/**
* 抓取实例
* @TableName spider_instance
*/
public class SpiderInstance extends Model<SpiderInstance> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 样本id
    */
    @ApiModelProperty("样本id")
    @TableField("sample_id")
    private Long sampleId;

    /**
    * 运行状态
    */
    @ApiModelProperty("运行状态")
    @TableField("run_status")
    private Integer runStatus;

    /**
    * 初始化开始时间
    */
    @ApiModelProperty("初始化开始时间")
    @TableField("init_start_time")
    private LocalDateTime initStartTime;

    /**
    * 初始化结束时间
    */
    @ApiModelProperty("初始化结束时间")
    @TableField("init_end_time")
    private LocalDateTime initEndTime;

    /**
    * 运行开始时间
    */
    @ApiModelProperty("运行开始时间")
    @TableField("run_start_time")
    private LocalDateTime runStartTime;

    /**
    * 运行结束时间
    */
    @ApiModelProperty("运行结束时间")
    @TableField("run_end_time")
    private LocalDateTime runEndTime;

    /**
    * 销毁开始时间
    */
    @ApiModelProperty("销毁开始时间")
    @TableField("destroy_start_time")
    private LocalDateTime destroyStartTime;

    /**
    * 销毁结束时间
    */
    @ApiModelProperty("销毁结束时间")
    @TableField("destroy_end_time")
    private LocalDateTime destroyEndTime;

    /**
    * 初始化消耗时间，毫秒
    */
    @ApiModelProperty("初始化消耗时间，毫秒")
    @TableField("init_cost_time")
    private Long initCostTime;

    /**
    * 运行消耗时间，毫秒
    */
    @ApiModelProperty("运行消耗时间，毫秒")
    @TableField("run_cost_time")
    private Long runCostTime;

    /**
    * 销毁消耗时间，毫秒
    */
    @ApiModelProperty("销毁消耗时间，毫秒")
    @TableField("destroy_cost_time")
    private Long destroyCostTime;

    /**
    * 总消耗时间，毫秒
    */
    @ApiModelProperty("总消耗时间，毫秒")
    @TableField("total_cost_time")
    private Long totalCostTime;

    /**
    * 重试次数
    */
    @ApiModelProperty("重试次数")
    @TableField("retry_time")
    private Integer retryTime;

    /**
    * 成功次数
    */
    @ApiModelProperty("成功次数")
    @TableField("success_time")
    private Integer successTime;

    /**
    * 失败次数
    */
    @ApiModelProperty("失败次数")
    @TableField("fail_time")
    private Integer failTime;

    /**
    * 成功率
    */
    @ApiModelProperty("成功率")
    @TableField("success_percent")
    private BigDecimal successPercent;

    /**
    * 失败率
    */
    @ApiModelProperty("失败率")
    @TableField("fail_percent")
    private BigDecimal failPercent;

    /**
    * 运行结果
    */
    @ApiModelProperty("运行结果")
    @TableField("run_result")
    private Integer runResult;

    /**
    * 异常消息
    */
    @ApiModelProperty("异常消息")
    @TableField("exception_msg")
    private String exceptionMsg;

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
