package com.scda.backend.common.core.enums;

import lombok.Getter;

@Getter
public enum VersionEnum {

    INIT_VERSION(1);

    VersionEnum(Integer version) {
        this.version = version;
    }

    private Integer version;
}
