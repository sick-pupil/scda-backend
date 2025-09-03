package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统租户DTO")
@Data
public class SystemTenantReadDTO implements Serializable {

    private static final long serialVersionUID = -4643606143764422857L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 租户名称
     */
    @ApiModelProperty("租户名称")
    private String name;

    /**
     * 租户编码
     */
    @ApiModelProperty("租户编码")
    private String code;
}
