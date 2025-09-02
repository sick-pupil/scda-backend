package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统菜单DTO")
@Data
public class SystemMenuReadDTO implements Serializable {

    private static final long serialVersionUID = -310442625168856850L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

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
}
