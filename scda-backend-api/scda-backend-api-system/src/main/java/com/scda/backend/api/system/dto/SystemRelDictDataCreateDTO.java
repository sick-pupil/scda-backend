package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建系统字典数据关联DTO")
@Data
public class SystemRelDictDataCreateDTO implements Serializable {

    private static final long serialVersionUID = 4240322169820175840L;

    /**
     * 字典id
     */
    @ApiModelProperty("字典id")
    @NotNull(message = "字典id非空")
    private Long dictId;

    /**
     * 字典数据id
     */
    @ApiModelProperty("字典数据id")
    @NotNull(message = "字典数据id非空")
    private Long dictDataId;
}
