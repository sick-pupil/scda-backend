package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统菜单DTO")
@Data
public class SystemMenuCreateDTO implements Serializable {

    private static final long serialVersionUID = -1216183586520778621L;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    @NotBlank(message = "菜单名称非空")
    private String name;

    /**
     * 菜单编码
     */
    @ApiModelProperty("菜单编码")
    @NotBlank(message = "菜单编码非空")
    private String code;

    /**
     * 父级菜单id
     */
    @ApiModelProperty("父级菜单id")
    @NotNull(message = "父级菜单非空")
    private Long parentId;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    @NotNull(message = "显示顺序非空")
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
     * 菜单类型，1菜单，2按钮
     */
    @ApiModelProperty("菜单类型，1菜单，2按钮")
    @NotNull(message = "菜单类型非空")
    private Integer type;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    @NotBlank(message = "菜单图标非空")
    private String icon;
}
