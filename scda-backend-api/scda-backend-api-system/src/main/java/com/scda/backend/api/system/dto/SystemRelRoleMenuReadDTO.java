package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统角色菜单关联DTO")
@Data
public class SystemRelRoleMenuReadDTO implements Serializable {

    private static final long serialVersionUID = 1710069624389093999L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Long roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    private Long menuId;
}
