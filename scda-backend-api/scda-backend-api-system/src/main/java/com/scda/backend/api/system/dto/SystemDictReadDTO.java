package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统字典DTO")
@Data
public class SystemDictReadDTO implements Serializable {

    private static final long serialVersionUID = -4327512680473632910L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

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
