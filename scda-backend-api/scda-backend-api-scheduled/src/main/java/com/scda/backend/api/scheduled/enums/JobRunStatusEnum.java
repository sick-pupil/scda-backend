package com.scda.backend.api.scheduled.enums;

import lombok.Getter;

@Getter
public enum JobRunStatusEnum {

    NEW(0),

    RUNNING(1),

    PAUSE(2),

    TERMINATE(3);

    JobRunStatusEnum(Integer runStatus) {
        this.runStatus = runStatus;
    }

    private Integer runStatus;
}
