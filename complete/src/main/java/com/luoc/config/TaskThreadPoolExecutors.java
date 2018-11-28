package com.luoc.config;

import java.util.concurrent.*;

/**
 * @author luoc
 * @date 2018/11/26 0026
 * @Time 11:45
 */
public class TaskThreadPoolExecutors extends ThreadPoolExecutor {
    public TaskThreadPoolExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TaskThreadPoolExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TaskThreadPoolExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TaskThreadPoolExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("start：" + t.getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("end： " + r.toString());
    }

    @Override
    protected void terminated() {
//        Java Concurrency in Practice
        System.out.println("线程池退出");
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }


    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(Runnable runnable, final Exception executorStack, String clientThreaName) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
                executorStack.printStackTrace();
                throw e;
            }
        };
    }
}
