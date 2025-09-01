package com.scda.backend.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDateTime;

@ApiModel(value="SystemRelRoleAuth对象", description="系统角色权限关联表")
@Data
@TableName("system_rel_role_auth")
/**
* 系统角色权限关联表
* @TableName system_rel_role_auth
*/
public class SystemRelRoleAuth extends Model<SystemRelRoleAuth> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 角色id
    */
    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Long roleId;

    /**
    * 权限id
    */
    @ApiModelProperty("权限id")
    @TableField("auth_id")
    private Long authId;

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
