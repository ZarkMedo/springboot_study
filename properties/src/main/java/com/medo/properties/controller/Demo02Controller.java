package com.medo.properties.controller;

import com.medo.properties.config.PropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoController
 * @Auther: medo
 * @Date: 2020-03-04 12:28
 * @Description: TODO
 **/
@RestController
//@PropertySource("classpath:application-111.properties")
@PropertySource(value = "classpath:application-111.yml", factory = PropertySourceFactory.class)
public class Demo02Controller {
    // 在使用注入的properties时，就可以像使用一般的bean一样使用

    @Value("${library.msg}")
    private String msg;

    @GetMapping("/movies01")
    public String getMovies() {
        return msg;
    }

}
