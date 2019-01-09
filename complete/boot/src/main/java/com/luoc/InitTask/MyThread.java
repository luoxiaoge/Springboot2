package com.luoc.InitTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 11:28
 */
@Component
public class MyThread implements Runnable {
    private  static final Logger log  = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        log.info("我是项目一启动就会执行的初始化方法");
    }
}
