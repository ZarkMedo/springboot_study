package com.medo.execption.controller;

import com.medo.execption.MyException.ClassNotFoundException;
import com.medo.execption.response.ErrorResponse;
import com.medo.execption.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @ClassName: IndexController
 * @Auther: medo
 * @Date: 2020-03-04 14:29
 * @Description: TODO
 **/
@RestController
public class IndexController {
    @GetMapping("/")
    public Response getIndex(HttpServletRequest request){
        Response response = null;

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "medo");
        data.put("sex", "gender");
        // 自行进行异常捕获
        try{
            throw new ClassNotFoundException(data);
        }catch (ClassNotFoundException e){
           response = new ErrorResponse(e, request.getPathInfo());
        }
        return response;
    }

    @GetMapping("/e1")
    // 抛错后通过全局异常捕获器捕获即可，捕获会从子类自下而上查找，这样的话，异常会更加精确
    public Response getE1(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "medo");
        data.put("sex", "gender");
        throw new ClassNotFoundException(data);
    }
}
