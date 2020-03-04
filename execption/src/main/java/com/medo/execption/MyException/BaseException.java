package com.medo.execption.MyException;

import com.medo.execption.enums.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseException
 * @Auther: medo
 * @Date: 2020-03-04 14:08
 * @Description: TODO
 **/
@Getter
public abstract class BaseException extends RuntimeException{

    private final ErrorCodeEnum errorCodeEnum;
    private final Map<String, Object> data = new HashMap<>();

    public BaseException(ErrorCodeEnum errorCodeEnum, Map<String, Object> data) {
        super(errorCodeEnum.getMsg());
        this.errorCodeEnum = errorCodeEnum;
        if (!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }
    }

    public BaseException(Throwable cause, ErrorCodeEnum errorCodeEnum, Map<String, Object> data) {
        super(errorCodeEnum.getMsg(), cause);
        this.errorCodeEnum = errorCodeEnum;
        if (!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }
    }
}
