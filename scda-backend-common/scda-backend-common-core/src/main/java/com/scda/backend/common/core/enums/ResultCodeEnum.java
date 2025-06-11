package com.scda.backend.common.core.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "success"),

    BUSINESS_ERROR(512, "businessError"),

    FAIL(500, "fail");

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;
}
