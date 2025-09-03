package com.scda.backend.api.system.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新系统字典数据DTO")
@Data
public class SystemDictDataUpdateDTO implements Serializable {

    private static final long serialVersionUID = -4780829552055338156L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;


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
