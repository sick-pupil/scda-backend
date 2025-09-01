package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统用户DTO")
@Data
public class SystemUserDeleteDTO implements Serializable {

    private static final long serialVersionUID = -9016689347324266717L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;
}
