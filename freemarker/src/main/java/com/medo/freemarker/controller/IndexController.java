package com.medo.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: IndexController
 * @Auther: medo
 * @Date: 2020-02-28 01:33
 * @Description: TODO
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String freemarkerTest() {
        System.out.println("访问第一个flth页面");
        return "test01";
    }

    @GetMapping("/f1")
    public String f1(ModelMap modelMap) {

        System.out.println("通过modelmap传参数");
        modelMap.addAttribute("name", "老王");
        modelMap.put("gender", "男");
        return "f1";
    }
    @GetMapping("/f2")
    public String f2(ModelMap modelMap) {

        System.out.println("传入list");
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "老王", "老李", "老刘", "老妈子");
        modelMap.addAttribute("list",list);
        return "f2";
    }


}
