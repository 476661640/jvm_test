package com.kicoder.thread;

import java.util.HashMap;
import java.util.Map;

public class ThreadTest {
    public static void main(String[] args) {

        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("这个异常没有来得及处理");
            }
        });


        System.out.println(10 / 0);
        ThreadLocal<HashMap> local = new ThreadLocal<>();
        ;
    }
}
