package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel("创建系统租户DTO")
@Data
public class SystemTenantCreateDTO implements Serializable {

    private static final long serialVersionUID = 3644219672862805737L;

    /**
     * 租户名称
     */
    @ApiModelProperty("租户名称")
    @NotBlank(message = "租户名称非空")
    private String name;

    /**
     * 租户编码
     */
    @ApiModelProperty("租户编码")
    @NotBlank(message = "租户编码非空")
    private String code;
}
