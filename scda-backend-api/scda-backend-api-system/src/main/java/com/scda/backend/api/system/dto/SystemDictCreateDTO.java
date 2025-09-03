package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel("创建系统字典DTO")
@Data
public class SystemDictCreateDTO implements Serializable {

    private static final long serialVersionUID = 7271277741387670417L;

    /**
     * 字典种类名称
     */
    @ApiModelProperty("字典种类名称")
    @NotBlank(message = "字典种类名称非空")
    private String name;

    /**
     * 字典种类编码
     */
    @ApiModelProperty("字典种类编码")
    @NotBlank(message = "字典种类编码非空")
    private String code;
}
