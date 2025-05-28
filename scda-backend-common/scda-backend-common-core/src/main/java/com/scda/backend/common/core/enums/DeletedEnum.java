package com.scda.backend.common.core.enums;

import lombok.Getter;

@Getter
public enum DeletedEnum {

    NON_DELETED(0),

    HAS_DELETED(1);

    DeletedEnum(Integer deleted) {
        this.deleted = deleted;
    }

    private Integer deleted;
}
