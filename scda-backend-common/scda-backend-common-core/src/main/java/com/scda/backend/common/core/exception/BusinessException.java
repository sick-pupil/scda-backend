package com.scda.backend.common.core.exception;

public class BusinessException extends RuntimeException {

    public BusinessException() {

    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }
}
