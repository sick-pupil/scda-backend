package com.scda.backend.api.scheduled.dto;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel("读取定时任务DTO")
@Data
public class ScheduledJobsReadDTO implements Serializable {

    private static final long serialVersionUID = 2735782716560222921L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * jobClass名称
     */
    @ApiModelProperty("jobClass名称")
    private String className;

    /**
     * job名称
     */
    @ApiModelProperty("job名称")
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
     * 是否故障恢复
     */
    @ApiModelProperty("是否故障恢复")
    private Boolean recovery;

    /**
     * 入参
     */
    @ApiModelProperty("入参")
    private JSONObject params;

    /**
     * 运行状态，0新建，1运行，暂停2，销毁3
     */
    @ApiModelProperty("运行状态，0新建，1运行，暂停2，销毁3")
    private Integer runStatus;

    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private Long creatorUserId;

    @ApiModelProperty("创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startCreateTime;

    @ApiModelProperty("创建结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endCreateTime;
}
