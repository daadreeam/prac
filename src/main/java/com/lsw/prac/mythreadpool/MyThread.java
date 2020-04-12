package com.lsw.prac.mythreadpool;

public class MyThread extends Thread {

    public MyThread (String name){
        super(name);
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        for(int i=0;i<3;i++) {
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程1");
        MyThread myThread1 = new MyThread("线程2");
        MyThread myThread2 = new MyThread("线程3");
        myThread.start();
        myThread1.start();
        myThread2.start();

    }
}
