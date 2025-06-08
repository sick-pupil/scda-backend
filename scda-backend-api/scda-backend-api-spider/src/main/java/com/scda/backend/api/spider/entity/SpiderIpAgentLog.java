package com.scda.backend.api.spider.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


@ApiModel(value="SpiderIpAgentLog对象", description="抓取使用代理池获取日志")
@Data
@TableName("spider_ip_agent_log")
/**
* 抓取使用代理池获取日志
* @TableName spider_ip_agent_log
*/
public class SpiderIpAgentLog extends Model<SpiderIpAgentLog> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 步骤id
    */
    @ApiModelProperty("步骤id")
    @TableField("step_id")
    private Long stepId;

    /**
    * ip代理池id
    */
    @ApiModelProperty("ip代理池id")
    @TableField("agent_ip_id")
    private Long agentIpId;

    /**
    * 代理ip
    */
    @ApiModelProperty("代理ip")
    @TableField("agent_ip")
    private String agentIp;

    /**
    * 获取代理结果
    */
    @ApiModelProperty("获取代理结果")
    @TableField("access_result")
    private Integer accessResult;

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
