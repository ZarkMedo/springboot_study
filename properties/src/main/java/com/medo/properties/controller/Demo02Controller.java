package com.medo.properties.controller;

import com.medo.properties.props.LibraryProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: DemoController
 * @Auther: medo
 * @Date: 2020-03-04 12:28
 * @Description: TODO
 **/
@RestController
public class Demo01Controller {
    // 在使用注入的properties时，就可以像使用一般的bean一样使用
    @Autowired
    private LibraryProperties libraryProperties;

    @GetMapping("/movies01")
    public List<LibraryProperties.Books> getMovies(){
        System.out.println(libraryProperties.getMovies());
        List<LibraryProperties.Books> movies = libraryProperties.getMovies();
        return movies;
    }

}
