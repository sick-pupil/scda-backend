package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统权限DTO")
@Data
public class SystemAuthReadDTO implements Serializable {

    private static final long serialVersionUID = 3788553253149268847L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;

    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String code;
}
