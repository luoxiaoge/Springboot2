package com.luoc.InitTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 10:57
 * test CommadLineRunner
 * 启动时   运行实现这个接口的run方法
 */
@Component
public class InitClass implements CommandLineRunner {


     @Autowired
     ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    MyThread thread;

     private  static final Logger  log  = LoggerFactory.getLogger(InitClass.class);

    @Override
    public void run(String... args) throws Exception {
        threadPoolExecutor.execute(thread);

    }
}
