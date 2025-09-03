package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统用户角色关联DTO")
@Data
public class SystemRelUserRoleReadDTO implements Serializable {

    private static final long serialVersionUID = 8363640185962760696L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Long roleId;
}
