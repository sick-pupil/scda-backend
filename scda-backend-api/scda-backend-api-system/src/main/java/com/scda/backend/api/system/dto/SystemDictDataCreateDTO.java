package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel("创建系统字典数据DTO")
@Data
public class SystemDictDataCreateDTO implements Serializable {

    private static final long serialVersionUID = 2436593992255967646L;

    /**
     * 字典数据名称
     */
    @ApiModelProperty("字典数据名称")
    @NotBlank(message = "字典数据名称非空")
    private String name;

    /**
     * 字典数据编码
     */
    @ApiModelProperty("字典数据编码")
    @NotBlank(message = "字典数据编码非空")
    private String code;
}
