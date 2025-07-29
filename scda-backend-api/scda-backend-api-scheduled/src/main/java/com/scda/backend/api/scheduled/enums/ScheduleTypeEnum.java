package com.scda.backend.api.scheduled.enums;

import lombok.Getter;

@Getter
public enum ScheduleTypeEnum {

    SIMPLE(0),

    CRON(1),

    CALENDAR(2),

    DAILY(3);

    ScheduleTypeEnum(Integer type) {
        this.type = type;
    }

    private Integer type;
}
