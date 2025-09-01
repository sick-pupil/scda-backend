package com.scda.backend.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDateTime;

@ApiModel(value="SystemUserLoginInfo对象", description="系统用户登录日志")
@Data
@TableName("system_user_login_info")
/**
* 系统用户登录日志
* @TableName system_user_login_info
*/
public class SystemUserLoginInfo extends Model<SystemUserLoginInfo> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    /**
    * 登录ip
    */
    @ApiModelProperty("登录ip")
    @TableField("ip")
    private String ip;

    /**
    * 登录地点
    */
    @ApiModelProperty("登录地点")
    @TableField("location")
    private String location;

    /**
    * 国家
    */
    @ApiModelProperty("国家")
    @TableField("country")
    private String country;

    /**
    * 省份
    */
    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    /**
    * 地市
    */
    @ApiModelProperty("地市")
    @TableField("city")
    private String city;

    /**
    * 区
    */
    @ApiModelProperty("区")
    @TableField("district")
    private String district;

    /**
    * 镇
    */
    @ApiModelProperty("镇")
    @TableField("town")
    private String town;

    /**
    * 登录设备
    */
    @ApiModelProperty("登录设备")
    @TableField("ua")
    private String ua;

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
