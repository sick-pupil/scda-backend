package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统角色菜单关联DTO")
@Data
public class SystemRelRoleMenuUpdateDTO implements Serializable {

    private static final long serialVersionUID = 7856722330870427103L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;


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
