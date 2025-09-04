package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统用户登录信息DTO")
@Data
public class SystemUserLoginInfoUpdateDTO implements Serializable {

    private static final long serialVersionUID = 7895297002654270530L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

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
