package com.scda.backend.api.scheduled.dto;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("创建定时任务DTO")
@Data
public class ScheduledJobsCreateDTO implements Serializable {

    private static final long serialVersionUID = -1302153651045347326L;

    /**
     * jobClass名称
     */
    @ApiModelProperty("jobClass名称")
    @NotBlank(message = "class名称非空")
    private String className;

    /**
     * job名称
     */
    @ApiModelProperty("job名称")
    @NotBlank(message = "名称非空")
    private String name;

    /**
     * 组名称
     */
    @ApiModelProperty("组名称")
    @NotBlank(message = "组名称非空")
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
    @NotNull(message = "是否故障恢复非空")
    private Boolean recovery;

    /**
     * 入参
     */
    @ApiModelProperty("入参")
    private JSONObject params;
}
