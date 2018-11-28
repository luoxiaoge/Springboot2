package com.luoc.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 11:47
 */
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class TaskThreadFactory implements ThreadFactory {
    private  Boolean daemon;
    private  Integer priority;
    final ReentrantLock mainLock = new ReentrantLock();
    private final ThreadGroup threadGroup;
    @Builder.Default
    private AtomicInteger poolNumberr = new AtomicInteger(1);
    @Builder.Default
    private  AtomicInteger threadNumber = new AtomicInteger(1);
    private final static String DEFAULT_NAME_PREFIX = "綫程池的-";
    private final static String DEFAULT_NAME_SUFFIX = "-xian'che线程-";


    private volatile String namePrefix=DEFAULT_NAME_PREFIX;

    public TaskThreadFactory() {
        SecurityManager securityManager = System.getSecurityManager();
        threadGroup = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        mainLock.lock();
        if (namePrefix == null && DEFAULT_NAME_PREFIX != null) {
            this.namePrefix = DEFAULT_NAME_PREFIX+poolNumberr+DEFAULT_NAME_SUFFIX;
        }
        mainLock.unlock();
        int andIncrement = threadNumber.getAndIncrement();
        System.out.println(andIncrement);
        Thread t = new Thread(threadGroup, r,
                namePrefix + andIncrement,
                0);
        if (getDaemon()!=null)
        {  t.setDaemon(getDaemon());}
        if (getPriority()!=null)
        {t.setPriority(getPriority());}
        return t;
    }
}
