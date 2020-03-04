package com.medo.execption.enums;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCodeEnum {
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "资源未找到"),
    REQUEST_PARAMS_FAILD(1002, HttpStatus.FORBIDDEN, "参数错误");

    private final int code;
    private final HttpStatus status;
    private final String msg;


    ErrorCodeEnum(int code, HttpStatus status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }
}
