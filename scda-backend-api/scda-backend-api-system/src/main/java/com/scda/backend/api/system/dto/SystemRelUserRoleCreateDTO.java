package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统用户角色关联DTO")
@Data
public class SystemRelUserRoleCreateDTO implements Serializable {

    private static final long serialVersionUID = -5338218009860543993L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @NotNull(message = "用户id非空")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @NotNull(message = "角色id非空")
    private Long roleId;
}
