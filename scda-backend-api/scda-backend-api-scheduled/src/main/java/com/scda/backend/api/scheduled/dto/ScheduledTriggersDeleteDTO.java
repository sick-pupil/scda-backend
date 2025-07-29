package com.scda.backend.api.scheduled.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("删除定时任务触发器DTO")
@Data
public class ScheduledTriggersDeleteDTO implements Serializable {

    private static final long serialVersionUID = 9119097662585223197L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "id非空")
    private Long id;
}
