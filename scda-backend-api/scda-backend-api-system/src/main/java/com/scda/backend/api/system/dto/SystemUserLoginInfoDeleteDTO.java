package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("删除系统用户登录信息DTO")
@Data
public class SystemUserLoginInfoDeleteDTO implements Serializable {

    private static final long serialVersionUID = -4169299249519976924L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;
}
