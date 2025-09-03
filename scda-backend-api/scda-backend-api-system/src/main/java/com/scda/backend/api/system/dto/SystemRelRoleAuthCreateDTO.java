package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统角色权限关联DTO")
@Data
public class SystemRelRoleAuthCreateDTO implements Serializable {

    private static final long serialVersionUID = 6038695561905203090L;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @NotNull(message = "角色id非空")
    private Long roleId;

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    @NotNull(message = "权限id非空")
    private Long authId;
}
