package com.medo.execption.response;

import lombok.Data;

import java.time.Instant;
import java.util.Map;

/**
 * @ClassName: Response
 * @Auther: medo
 * @Date: 2020-03-04 14:30
 * @Description: TODO
 **/
@Data
public class Response {
    private Integer code;
    private Integer status;
    private String path;
    private Instant time;
    private String msg;
    private Map<String, Object> data;
}
