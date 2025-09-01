package com.scda.backend.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDateTime;

@ApiModel(value="SystemApiOperLog对象", description="系统接口操作日志")
@Data
@TableName("system_api_oper_log")
/**
* 系统接口操作日志
* @TableName system_api_oper_log
*/
public class SystemApiOperLog extends Model<SystemApiOperLog> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 请求url
    */
    @ApiModelProperty("请求url")
    @TableField("req_url")
    private String reqUrl;

    /**
    * 请求方式
    */
    @ApiModelProperty("请求方式")
    @TableField("req_method")
    private String reqMethod;

    /**
    * 请求发起ip
    */
    @ApiModelProperty("请求发起ip")
    @TableField("req_ip")
    private String reqIp;

    /**
    * 请求发起地址
    */
    @ApiModelProperty("请求发起地址")
    @TableField("req_location")
    private String reqLocation;

    /**
    * 请求发起国家
    */
    @ApiModelProperty("请求发起国家")
    @TableField("req_country")
    private String reqCountry;

    /**
    * 请求发起省份
    */
    @ApiModelProperty("请求发起省份")
    @TableField("req_province")
    private String reqProvince;

    /**
    * 请求发起地市
    */
    @ApiModelProperty("请求发起地市")
    @TableField("req_city")
    private String reqCity;

    /**
    * 请求发起区
    */
    @ApiModelProperty("请求发起区")
    @TableField("req_district")
    private String reqDistrict;

    /**
    * 请求发起镇
    */
    @ApiModelProperty("请求发起镇")
    @TableField("req_town")
    private String reqTown;

    /**
    * 请求参数
    */
    @ApiModelProperty("请求参数")
    @TableField("req_params")
    private String reqParams;

    /**
    * 响应参数
    */
    @ApiModelProperty("响应参数")
    @TableField("resp_params")
    private String respParams;

    /**
    * 响应类型，1正常，2业务异常，3运行异常
    */
    @ApiModelProperty("响应类型，1正常，2业务异常，3运行异常")
    @TableField("resp_type")
    private Integer respType;

    /**
    * 异常内容
    */
    @ApiModelProperty("异常内容")
    @TableField("exception_msg")
    private String exceptionMsg;

    /**
    * 消耗时间，单位毫秒
    */
    @ApiModelProperty("消耗时间，单位毫秒")
    @TableField("cost_time")
    private Long costTime;

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
