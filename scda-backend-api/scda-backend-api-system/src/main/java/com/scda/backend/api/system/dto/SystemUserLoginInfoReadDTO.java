package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统用户登录信息DTO")
@Data
public class SystemUserLoginInfoReadDTO implements Serializable {

    private static final long serialVersionUID = 8266819351291902345L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 登录ip
     */
    @ApiModelProperty("登录ip")
    private String ip;

    /**
     * 登录地点
     */
    @ApiModelProperty("登录地点")
    private String location;

    /**
     * 国家
     */
    @ApiModelProperty("国家")
    private String country;

    /**
     * 省份
     */
    @ApiModelProperty("省份")
    private String province;

    /**
     * 地市
     */
    @ApiModelProperty("地市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String district;

    /**
     * 镇
     */
    @ApiModelProperty("镇")
    private String town;

    /**
     * 登录设备
     */
    @ApiModelProperty("登录设备")
    private String ua;
}
