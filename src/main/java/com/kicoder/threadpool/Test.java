package com.kicoder.threadpool;

import javafx.concurrent.Worker;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    //private final BlockingQueue<Runnable> workQueue;              //任务缓存队列，用来存放等待执行的任务
    private final ReentrantLock mainLock = new ReentrantLock();   //线程池的主要状态锁，对线程池状态（比如线程池大小
    //、runState等）的改变都要使用这个锁
    private final HashSet<Worker> workers = new HashSet<Worker>();  //用来存放工作集

    private volatile long  keepAliveTime;    //线程存活时间
    private volatile boolean allowCoreThreadTimeOut;   //是否允许为核心线程设置存活时间
    private volatile int   corePoolSize;     //核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
    private volatile int   maximumPoolSize;   //线程池最大能容忍的线程数

    private volatile int   poolSize;       //线程池中当前的线程数

    private volatile RejectedExecutionHandler handler; //任务拒绝策略

    private volatile ThreadFactory threadFactory;   //线程工厂，用来创建线程

    private int largestPoolSize;   //用来记录线程池中曾经出现过的最大线程数

    private long completedTaskCount;   //用来记录已经执行完毕的任务个数
}
