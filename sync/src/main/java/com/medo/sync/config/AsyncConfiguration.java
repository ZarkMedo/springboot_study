package com.medo.sync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: AsyncConfiguration
 * @Auther: medo
 * @Date: 2020-03-04 17:27
 * @Description: TODO
 **/
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {
    // 设置队列数，核心线程数，最大线程数,也可以通过之前学习的properties读取到类中
    private static final int CORE_POOL_SIZE = 6;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 10;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);

        // 设置线程超出最大队列数的处理策略， 此策略为等待处理，会影响性能，但是任务不会丢失
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 设置线程前缀
        taskExecutor.setThreadNamePrefix("medo's thread");
        // 初始化
        taskExecutor.initialize();

        return taskExecutor;

    }

}
