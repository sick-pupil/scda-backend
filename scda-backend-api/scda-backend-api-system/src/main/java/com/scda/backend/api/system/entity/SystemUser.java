package com.scda.backend.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDateTime;

@ApiModel(value="SystemUser对象", description="系统用户")
@Data
@TableName("system_user")
/**
* 系统用户
* @TableName system_user
*/
public class SystemUser extends Model<SystemUser> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 账号
    */
    @ApiModelProperty("账号")
    @TableField("account")
    private String account;

    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    /**
    * 邮箱号
    */
    @ApiModelProperty("邮箱号")
    @TableField("email")
    private String email;

    /**
    * 手机号
    */
    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    /**
    * 密码
    */
    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    /**
    * 头像
    */
    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

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
