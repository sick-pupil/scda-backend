package com.scda.backend.common.core.domain;

import com.scda.backend.common.core.enums.ResultCodeEnum;

import java.io.Serializable;
import java.util.List;

public class Table<T> implements Serializable {

    private static final long serialVersionUID = 2614422449725127322L;

    private List<T> rows;

    private Long totalSize;

    private Integer code;

    private String msg;

    private Table() {

    }

    private Table(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Table(List<T> rows, Long totalSize) {
        this.rows = rows;
        this.totalSize = totalSize;
    }

    private Table(List<T> rows, Long totalSize, String msg) {
        this.rows = rows;
        this.msg = msg;
        this.totalSize = totalSize;
    }

    private Table(List<T> rows, Long totalSize, Integer code, String msg) {
        this.rows = rows;
        this.code = code;
        this.msg = msg;
        this.totalSize = totalSize;
    }

    public static <T> Table<T> success() {
        return new Table(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static <T> Table<T> success(String msg) {
        return new Table(ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Table<T> success(List<T> rows, Long totalSize) {
        return new Table(rows, totalSize, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static <T> Table<T> success(List<T> rows, Long totalSize, String msg) {
        return new Table(rows, totalSize, ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Table<T> businessError(String msg) {
        return new Table(ResultCodeEnum.BUSINESS_ERROR.getCode(), msg);
    }

    public static <T> Table<T> businessError(List<T> rows, Long totalSize) {
        return new Table(rows, totalSize, ResultCodeEnum.BUSINESS_ERROR.getCode(), ResultCodeEnum.BUSINESS_ERROR.getMsg());
    }

    public static <T> Table<T> businessError(List<T> rows, Long totalSize, String msg) {
        return new Table(rows, totalSize, ResultCodeEnum.BUSINESS_ERROR.getCode(), msg);
    }

    public static <T> Table<T> fail(String msg) {
        return new Table(ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static <T> Table<T> fail(List<T> rows, Long totalSize) {
        return new Table(rows, totalSize, ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getMsg());
    }

    public static <T> Table<T> fail(List<T> rows, Long totalSize, String msg) {
        return new Table(rows, totalSize, ResultCodeEnum.FAIL.getCode(), msg);
    }
}
