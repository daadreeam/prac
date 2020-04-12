package com.lsw.prac.mythreadpool;

import java.util.Date;

public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable("sss"));
        Thread thread2 = new Thread(new MyRunnable("sss"));
        Thread thread3 = new Thread(new MyRunnable("sss"));
        thread.start();
        thread2.start();
        thread3.start();
    }
}
