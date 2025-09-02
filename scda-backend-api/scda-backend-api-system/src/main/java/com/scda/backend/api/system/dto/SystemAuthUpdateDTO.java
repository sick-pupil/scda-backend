package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统权限DTO")
@Data
public class SystemAuthUpdateDTO implements Serializable {

    private static final long serialVersionUID = -1926888447996986920L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

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
