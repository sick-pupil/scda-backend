package com.scda.backend.api.scheduled.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("删除定时任务DTO")
@Data
public class ScheduledJobDeleteDTO implements Serializable {

    private static final long serialVersionUID = 4110045504000280112L;

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;
}
