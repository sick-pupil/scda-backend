package com.scda.backend.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDateTime;

@ApiModel(value="SystemMenu对象", description="系统菜单")
@Data
@TableName("system_menu")
/**
* 系统菜单
* @TableName system_menu
*/
public class SystemMenu extends Model<SystemMenu> {


    /**
    * 主键id
    */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
    * 菜单名称
    */
    @ApiModelProperty("菜单名称")
    @TableField("name")
    private String name;

    /**
    * 菜单编码
    */
    @ApiModelProperty("菜单编码")
    @TableField("code")
    private String code;

    /**
    * 父级菜单id
    */
    @ApiModelProperty("父级菜单id")
    @TableField("parent_id")
    private Long parentId;

    /**
    * 显示顺序
    */
    @ApiModelProperty("显示顺序")
    @TableField("order_seq")
    private Integer orderSeq;

    /**
    * 组件路径
    */
    @ApiModelProperty("组件路径")
    @TableField("component_path")
    private String componentPath;

    /**
    * 组件名称
    */
    @ApiModelProperty("组件名称")
    @TableField("component_name")
    private String componentName;

    /**
    * 组件
    */
    @ApiModelProperty("组件")
    @TableField("component")
    private String component;

    /**
    * 1菜单，2按钮
    */
    @ApiModelProperty("1菜单，2按钮")
    @TableField("type")
    private Integer type;

    /**
    * 菜单图标
    */
    @ApiModelProperty("菜单图标")
    @TableField("icon")
    private String icon;

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
