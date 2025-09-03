package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统租户DTO")
@Data
public class SystemTenantUpdateDTO implements Serializable {

    private static final long serialVersionUID = -2045208710791012672L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

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
