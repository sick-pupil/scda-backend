package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统接口操作日志DTO")
@Data
public class SystemApiOperLogReadDTO implements Serializable {

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 请求url
     */
    @ApiModelProperty("请求url")
    private String reqUrl;

    /**
     * 请求方式
     */
    @ApiModelProperty("请求方式")
    private String reqMethod;

    /**
     * 请求发起ip
     */
    @ApiModelProperty("请求发起ip")
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
    private Long costTime;
}
