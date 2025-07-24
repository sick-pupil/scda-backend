package com.scda.backend.api.scheduled.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("删除定时任务DTO")
@Data
public class ScheduledJobsDeleteDTO implements Serializable {

    private static final long serialVersionUID = 4110045504000280112L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;
}
