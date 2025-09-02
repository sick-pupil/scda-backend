package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel("创建系统权限DTO")
@Data
public class SystemAuthCreateDTO implements Serializable {

    private static final long serialVersionUID = -3012307804768409159L;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    @NotBlank(message = "权限名称非空")
    private String name;

    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    @NotBlank(message = "权限编码非空")
    private String code;
}
