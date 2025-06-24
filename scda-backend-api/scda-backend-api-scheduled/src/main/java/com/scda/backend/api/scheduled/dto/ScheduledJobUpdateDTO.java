package com.scda.backend.api.scheduled.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("更新定时任务DTO")
@Data
public class ScheduledJobUpdateDTO implements Serializable {

    private static final long serialVersionUID = 2453355551027954882L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;
}
