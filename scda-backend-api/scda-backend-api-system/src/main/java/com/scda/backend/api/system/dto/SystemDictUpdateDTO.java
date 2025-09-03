package com.scda.backend.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统字典DTO")
@Data
public class SystemDictUpdateDTO implements Serializable {

    private static final long serialVersionUID = -4501125636773610688L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

    /**
     * 字典种类名称
     */
    @ApiModelProperty("字典种类名称")
    private String name;

    /**
     * 字典种类编码
     */
    @ApiModelProperty("字典种类编码")
    private String code;
}
