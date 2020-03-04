package com.medo.sync.service.impl;

import com.medo.sync.model.entity.Cook;
import com.medo.sync.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @ClassName: ShoppingServiceImpl
 * @Auther: medo
 * @Date: 2020-03-04 17:48
 * @Description: TODO
 **/
@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    @Override
    public Cook cookFood() throws ExecutionException, InterruptedException {
        // 做美食需要两步，第一大步网购购买锅子， 第二大步买食材，第三大步 做美食

        long start = System.currentTimeMillis();

//        String meat = shopMeat();


        Future<String> guoziFuture = taskExecutor.submit(this::internetShop);

        Future<String> meatFuture = taskExecutor.submit(this::shopMeat);


        // long end = System.currentTimeMillis();// 在这里end的时间为0，因为都没有获取返回值，所以都不会阻塞主线程

        Cook cook = new Cook("使用厨具"+guoziFuture.get()+",和"+meatFuture.get()+"制作而成");
        long end = System.currentTimeMillis();
        System.out.println("花费时间: "+ (end-start)); // 在这里花费时间为线程的最大阻塞时间

        return cook;
    }

    public String shopMeat(){

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "羊肉";
    }

    public String internetShop() {
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return ("就养牌锅子");
    }
}
