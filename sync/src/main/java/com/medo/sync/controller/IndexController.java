package com.medo.sync.controller;

import com.medo.sync.model.entity.Cook;
import com.medo.sync.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @ClassName: IndexController
 * @Auther: medo
 * @Date: 2020-03-04 18:00
 * @Description: TODO
 **/
@RestController
public class IndexController {

    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/")
    public Cook getCook() throws ExecutionException, InterruptedException {
        return shoppingService.cookFood();
    }

}
