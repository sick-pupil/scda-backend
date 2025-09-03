package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统字典数据DTO")
@Data
public class SystemDictDataReadDTO implements Serializable {

    private static final long serialVersionUID = 1252067505933299561L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

    /**
     * 字典数据名称
     */
    @ApiModelProperty("字典数据名称")
    private String name;

    /**
     * 字典数据编码
     */
    @ApiModelProperty("字典数据编码")
    private String code;
}
