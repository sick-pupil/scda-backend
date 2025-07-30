package com.scda.backend.api.scheduled.vo;

import com.scda.backend.api.scheduled.entity.ScheduledTriggers;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("定时任务触发器VO")
@Data
public class ScheduledTriggersDetailVO extends ScheduledTriggers implements Serializable {

    private static final long serialVersionUID = -3835335587250054007L;
}
