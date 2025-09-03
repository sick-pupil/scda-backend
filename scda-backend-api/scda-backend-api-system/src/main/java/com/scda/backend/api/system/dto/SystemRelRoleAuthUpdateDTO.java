package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统角色权限关联DTO")
@Data
public class SystemRelRoleAuthUpdateDTO implements Serializable {

    private static final long serialVersionUID = -2332541338430802872L;

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
     * 权限id
     */
    @ApiModelProperty("权限id")
    private Long authId;
}
