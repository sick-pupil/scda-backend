package com.scda.backend.api.system.dto;

import com.scda.backend.common.core.domain.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("读取系统字典数据关联DTO")
@Data
public class SystemRelDictDataReadDTO implements Serializable {

    private static final long serialVersionUID = -8000879516516620854L;

    @ApiModelProperty("分页参数")
    private PageQuery pageQuery;

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
