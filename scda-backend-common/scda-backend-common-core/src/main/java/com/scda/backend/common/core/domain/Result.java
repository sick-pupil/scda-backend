package com.scda.backend.common.core.domain;

import com.scda.backend.common.core.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3117221057211547701L;

    private T data;

    private Integer code;

    private String msg;

    private Result() {

    }

    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    private Result(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> success() {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static <T> Result<T> success(String msg) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(T data) {
        return new Result(data, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result(data, ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> businessError() {
        return new Result(ResultCodeEnum.BUSINESS_ERROR.getCode(), ResultCodeEnum.BUSINESS_ERROR.getMsg());
    }

    public static <T> Result<T> businessError(String msg) {
        return new Result(ResultCodeEnum.BUSINESS_ERROR.getCode(), msg);
    }

    public static <T> Result<T> businessError(T data) {
        return new Result(data, ResultCodeEnum.BUSINESS_ERROR.getCode(), ResultCodeEnum.BUSINESS_ERROR.getMsg());
    }

    public static <T> Result<T> businessError(T data, String msg) {
        return new Result(data, ResultCodeEnum.BUSINESS_ERROR.getCode(), msg);
    }

    public static <T> Result<T> fail() {
        return new Result(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static <T> Result<T> fail(T data) {
        return new Result(data, ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }

    public static <T> Result<T> fail(T data, String msg) {
        return new Result(data, ResultCodeEnum.FAIL.getCode(), msg);
    }
}
