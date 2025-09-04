package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统接口操作日志DTO")
@Data
public class SystemApiOperLogCreateDTO implements Serializable {

    private static final long serialVersionUID = -8670050078100875100L;

    /**
     * 请求url
     */
    @ApiModelProperty("请求url")
    @NotBlank(message = "请求url非空")
    private String reqUrl;

    /**
     * 请求方式
     */
    @ApiModelProperty("请求方式")
    @NotBlank(message = "请求方式非空")
    private String reqMethod;

    /**
     * 请求发起ip
     */
    @ApiModelProperty("请求发起ip")
    @NotBlank(message = "请求发起ip非空")
    private String reqIp;

    /**
     * 请求发起地址
     */
    @ApiModelProperty("请求发起地址")
    private String reqLocation;

    /**
     * 请求发起国家
     */
    @ApiModelProperty("请求发起国家")
    private String reqCountry;

    /**
     * 请求发起省份
     */
    @ApiModelProperty("请求发起省份")
    private String reqProvince;

    /**
     * 请求发起地市
     */
    @ApiModelProperty("请求发起地市")
    private String reqCity;

    /**
     * 请求发起区
     */
    @ApiModelProperty("请求发起区")
    private String reqDistrict;

    /**
     * 请求发起镇
     */
    @ApiModelProperty("请求发起镇")
    private String reqTown;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String reqParams;

    /**
     * 响应参数
     */
    @ApiModelProperty("响应参数")
    private String respParams;

    /**
     * 响应类型，1正常，2业务异常，3运行异常
     */
    @ApiModelProperty("响应类型，1正常，2业务异常，3运行异常")
    @NotNull(message = "响应类型非空")
    private Integer respType;

    /**
     * 异常内容
     */
    @ApiModelProperty("异常内容")
    private String exceptionMsg;

    /**
     * 消耗时间，单位毫秒
     */
    @ApiModelProperty("消耗时间，单位毫秒")
    @NotNull(message = "消耗时间非空")
    private Long costTime;
}
