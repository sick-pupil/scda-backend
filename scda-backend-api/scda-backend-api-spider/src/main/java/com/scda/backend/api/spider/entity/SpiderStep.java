package com.scda.backend.api.spider.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value="SpiderStep对象", description="抓取步骤")
@Data
@TableName("spider_step")
/**
* 抓取步骤
* @TableName spider_step
*/
public class SpiderStep extends Model<SpiderStep> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 实例id
    */
    @ApiModelProperty("实例id")
    @TableField("instance_id")
    private Long instanceId;

    /**
    * 请求地址
    */
    @ApiModelProperty("请求地址")
    @TableField("req_url")
    private String reqUrl;

    /**
    * 请求方式
    */
    @ApiModelProperty("请求方式")
    @TableField("req_method")
    private String reqMethod;

    /**
    * 请求头
    */
    @ApiModelProperty("请求头")
    @TableField("req_header")
    private String reqHeader;

    /**
    * 请求体
    */
    @ApiModelProperty("请求体")
    @TableField("req_body")
    private String reqBody;

    /**
    * 响应头
    */
    @ApiModelProperty("响应头")
    @TableField("resp_header")
    private String respHeader;

    /**
    * 响应体
    */
    @ApiModelProperty("响应体")
    @TableField("resp_body")
    private String respBody;

    /**
    * 响应码
    */
    @ApiModelProperty("响应码")
    @TableField("resp_status_code")
    private Integer respStatusCode;

    /**
    * 构建请求开始时间
    */
    @ApiModelProperty("构建请求开始时间")
    @TableField("build_req_start_time")
    private LocalDateTime buildReqStartTime;

    /**
    * 构建请求结束时间
    */
    @ApiModelProperty("构建请求结束时间")
    @TableField("build_req_end_time")
    private LocalDateTime buildReqEndTime;

    /**
    * 请求开始时间
    */
    @ApiModelProperty("请求开始时间")
    @TableField("req_start_time")
    private LocalDateTime reqStartTime;

    /**
    * 请求结束时间
    */
    @ApiModelProperty("请求结束时间")
    @TableField("req_end_time")
    private LocalDateTime reqEndTime;

    /**
    * 处理响应开始时间
    */
    @ApiModelProperty("处理响应开始时间")
    @TableField("resp_process_start_time")
    private LocalDateTime respProcessStartTime;

    /**
    * 处理响应结束时间
    */
    @ApiModelProperty("处理响应结束时间")
    @TableField("resp_process_end_time")
    private LocalDateTime respProcessEndTime;

    /**
    * 构建请求花费时间，毫秒
    */
    @ApiModelProperty("构建请求花费时间，毫秒")
    @TableField("build_req_cost_time")
    private Long buildReqCostTime;

    /**
    * 请求花费时间，毫秒
    */
    @ApiModelProperty("请求花费时间，毫秒")
    @TableField("req_cost_time")
    private Long reqCostTime;

    /**
    * 处理响应花费时间，毫秒
    */
    @ApiModelProperty("处理响应花费时间，毫秒")
    @TableField("resp_process_cost_time")
    private Long respProcessCostTime;

    /**
    * 总花费时间，毫秒
    */
    @ApiModelProperty("总花费时间，毫秒")
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
