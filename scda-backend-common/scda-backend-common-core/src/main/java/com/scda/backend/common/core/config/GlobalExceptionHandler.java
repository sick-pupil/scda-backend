package com.scda.backend.common.core.config;

import com.scda.backend.common.core.domain.Result;
import com.scda.backend.common.core.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result handleException(BusinessException ex) {
        return Result.businessError(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result handleException(RuntimeException ex) {
        return Result.fail(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        return Result.fail(ex.getMessage());
    }
}
