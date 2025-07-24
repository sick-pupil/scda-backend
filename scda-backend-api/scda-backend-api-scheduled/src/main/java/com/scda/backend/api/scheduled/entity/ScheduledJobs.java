package com.scda.backend.api.scheduled.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


@ApiModel(value="ScheduledJob对象", description="")
@Data
@TableName(value = "scheduled_jobs", autoResultMap = true)
/**
* 
* @TableName scheduled_job
*/
public class ScheduledJobs extends Model<ScheduledJobs> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * jobClass名称
    */
    @ApiModelProperty("jobClass名称")
    @TableField("class_name")
    private String className;

    /**
    * job名称
    */
    @ApiModelProperty("job名称")
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
    * 是否故障恢复
    */
    @ApiModelProperty("是否故障恢复")
    @TableField("recovery")
    private Boolean recovery;

    /**
    * 入参
    */
    @ApiModelProperty("入参")
    @TableField(value = "params", typeHandler = FastjsonTypeHandler.class)
    private JSONObject params;

    /**
     * 运行状态，0新建，1运行，暂停2，销毁3
     */
    @ApiModelProperty("运行状态，0新建，1运行，暂停2，销毁3")
    @TableField("run_status")
    private Integer runStatus;

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
