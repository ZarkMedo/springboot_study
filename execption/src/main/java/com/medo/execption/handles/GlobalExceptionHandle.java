package com.medo.execption.handles;

import com.medo.execption.MyException.BaseException;
import com.medo.execption.response.ErrorResponse;
import com.medo.execption.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: GlobalException
 * @Auther: medo
 * @Date: 2020-03-04 15:10
 * @Description: TODO
 **/

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleException(BaseException ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex, request.getRequestURI());

        return new ResponseEntity<>(errorResponse, new HttpHeaders(), ex.getErrorCodeEnum().getStatus());
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<?> handleClassNotFoundException(BaseException ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex, request.getRequestURI());

        return ResponseEntity.status(ex.getErrorCodeEnum().getStatus()).body(errorResponse);
    }


}
