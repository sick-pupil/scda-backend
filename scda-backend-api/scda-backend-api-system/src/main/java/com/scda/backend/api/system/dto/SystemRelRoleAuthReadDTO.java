package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统角色权限关联DTO")
@Data
public class SystemRelRoleAuthReadDTO implements Serializable {

    private static final long serialVersionUID = 3154362067097979092L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

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
