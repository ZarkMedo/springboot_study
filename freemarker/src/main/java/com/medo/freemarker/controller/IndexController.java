package com.medo.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

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
        modelMap.addAttribute("list", list);
        return "f2";
    }

    @GetMapping("/f3")
    public String f3(ModelMap modelMap) {

        System.out.println("传入map");
        Map<String, String> map = new HashMap<>();
        map.put("name", "老习");
        map.put("gender", "男");
        map.put("like", "女");
        map.put("age", "64");
        map.put("address", "中南海");
        modelMap.addAttribute("map", map);
        return "f3";
    }

    @GetMapping("/f4")
    public String f4(ModelMap modelMap) {

        System.out.println("if判断");
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "老王", "老李", "老刘", "老妈子", "老牛", "老冰");
        modelMap.addAttribute("list", list);
        return "f4";
    }

    @GetMapping("/f5")
    public String f5(ModelMap modelMap) {

        return "f5";
    }
}
