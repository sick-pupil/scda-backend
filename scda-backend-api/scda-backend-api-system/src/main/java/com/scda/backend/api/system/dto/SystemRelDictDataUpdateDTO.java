package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统字典数据关联DTO")
@Data
public class SystemRelDictDataUpdateDTO implements Serializable {

    private static final long serialVersionUID = 6344483819818241093L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

    /**
     * 字典id
     */
    @ApiModelProperty("字典id")
    private Long dictId;

    /**
     * 字典数据id
     */
    @ApiModelProperty("字典数据id")
    private Long dictDataId;
}
