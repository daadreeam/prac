package com.lsw.prac.mythreadpool;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {

    int order;

    public MyCallable(int i){
        this.order  = i;
    }
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {

        Date startTime = new Date();
        if (Thread.currentThread().getName().contains("main")) {
            System.out.println("==========main==================");
        }
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + startTime);
        processCommand();
        Date endTime = new Date();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + endTime);

        if (Thread.currentThread().getName().contains("main")) {
            System.out.println("==========main==================");
        }
        return order + Thread.currentThread().getName() +  "线程执行完毕 所用时间为: " + (endTime.getTime() - startTime.getTime());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable(1);
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyCallable(12));
        FutureTask<String> stringFutureTask2 = new FutureTask<>(new MyCallable(13));
        FutureTask<String> stringFutureTask3 = new FutureTask<>(new MyCallable(14));

        Thread thread = new Thread(stringFutureTask);
        Thread thread2 = new Thread(stringFutureTask2);
        Thread thread3 = new Thread(stringFutureTask3);
        thread.start();
        thread2.start();
        thread3.start();
    }
}
