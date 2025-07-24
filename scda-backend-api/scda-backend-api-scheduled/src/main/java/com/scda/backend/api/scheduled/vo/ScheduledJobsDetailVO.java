package com.scda.backend.api.scheduled.vo;

import com.scda.backend.api.scheduled.entity.ScheduledJobs;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@ApiModel("定时任务VO")
@Data
public class ScheduledJobsDetailVO extends ScheduledJobs implements Serializable {

    private static final long serialVersionUID = -1851147318116226851L;
}
