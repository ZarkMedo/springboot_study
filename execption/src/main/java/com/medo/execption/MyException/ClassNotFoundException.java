package com.medo.execption.MyException;

import com.medo.execption.enums.ErrorCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ClassNotFoundException
 * @Auther: medo
 * @Date: 2020-03-04 14:23
 * @Description: TODO
 **/
public class ClassNotFoundException extends BaseException {
    public ClassNotFoundException(Map<String, Object> data) {
        super(ErrorCodeEnum.RESOURCE_NOT_FOUND, data);
    }

    public ClassNotFoundException(Throwable cause, Map<String, Object> data) {
        super(cause, ErrorCodeEnum.RESOURCE_NOT_FOUND, data);
    }
}
