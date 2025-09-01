package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统角色DTO")
@Data
public class SystemRoleReadDTO implements Serializable {

    private static final long serialVersionUID = -1940936277725285952L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String code;
}
