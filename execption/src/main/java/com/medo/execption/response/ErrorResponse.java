package com.medo.execption.response;

import com.medo.execption.MyException.BaseException;
import com.medo.execption.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;
import java.util.HashMap;

/**
 * @ClassName: ErrorResponse
 * @Auther: medo
 * @Date: 2020-03-04 14:25
 * @Description: TODO
 **/
@Data
public class ErrorResponse extends Response{

    public ErrorResponse() {
    }

    public ErrorResponse(BaseException ex, String path) {
        super.setPath(path);
        ErrorCodeEnum errorCodeEnum = ex.getErrorCodeEnum();
        super.setStatus(errorCodeEnum.getStatus().value());
        super.setCode(errorCodeEnum.getCode());
        super.setMsg(errorCodeEnum.getMsg());
        super.setTime(Instant.now());
        super.setData(ex.getData());

    }
}
