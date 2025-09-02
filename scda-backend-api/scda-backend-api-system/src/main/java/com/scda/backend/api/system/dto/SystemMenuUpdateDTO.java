package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统菜单DTO")
@Data
public class SystemMenuUpdateDTO implements Serializable {

    private static final long serialVersionUID = -5001339690189151532L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 菜单编码
     */
    @ApiModelProperty("菜单编码")
    private String code;

    /**
     * 父级菜单id
     */
    @ApiModelProperty("父级菜单id")
    private Long parentId;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer orderSeq;

    /**
     * 组件路径
     */
    @ApiModelProperty("组件路径")
    private String componentPath;

    /**
     * 组件名称
     */
    @ApiModelProperty("组件名称")
    private String componentName;

    /**
     * 组件
     */
    @ApiModelProperty("组件")
    private String component;

    /**
     * 1菜单，2按钮
     */
    @ApiModelProperty("1菜单，2按钮")
    private Integer type;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;
}
