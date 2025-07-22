package com.scda.backend.api.scheduled.dto;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("更新定时任务DTO")
@Data
public class ScheduledJobUpdateDTO implements Serializable {

    private static final long serialVersionUID = 2453355551027954882L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;

    /**
     * jobClass名称
     */
    @ApiModelProperty("jobClass名称")
    private String className;

    /**
     * job名称
     */
    @ApiModelProperty("job名称")
    private String name;

    /**
     * 组名称
     */
    @ApiModelProperty("组名称")
    private String group;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String desc;

    /**
     * 是否故障恢复
     */
    @ApiModelProperty("是否故障恢复")
    private Boolean recovery;

    /**
     * 入参
     */
    @ApiModelProperty("入参")
    private JSONObject params;
}
