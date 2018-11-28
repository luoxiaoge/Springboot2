package com.luoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 11:47
 */
@Configuration
public class ThreadConfiguration {

    @Bean("threadFactory")
    public ThreadPoolExecutor threadFactory(){
        return  new TaskThreadPoolExecutors(Runtime.getRuntime().availableProcessors(),10,1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10),TaskThreadFactory.builder().priority(Thread.NORM_PRIORITY).namePrefix("我想要帅一点的提示  ---------- ").daemon(false).build());
    }
}
