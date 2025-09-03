package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统角色菜单关联DTO")
@Data
public class SystemRelRoleMenuCreateDTO implements Serializable {

    private static final long serialVersionUID = 8006359910251449872L;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @NotNull(message = "角色id非空")
    private Long roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    @NotNull(message = "菜单id非空")
    private Long menuId;
}
