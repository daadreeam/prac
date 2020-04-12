package com.lsw.prac.mythreadpool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadPoolDemo {


    // todo 何时使用core_pool_size，何时用max_pool_size，还有就是拒绝策略的问题
    // 自己实际测试得到了答案
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 4;
    private static final int QUEUE_CAPACITY = 5;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.AbortPolicy()
        );

        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            //创建WorkerThread对象(WorkerThread类实现了Runnable 接口)
//            Runnable worker = new MyRunnable("" + i);
            MyCallable worker = new MyCallable(i);
            //执行Runnable
//            executor.execute(worker);
            Future<String> submit = executor.submit(worker);
            futures.add(submit);
//            String s = submit.get();
//            System.out.println("s = " + s);
        }

        // todo 这个是什么意思呢？
        executor.shutdown();

        while (!executor.isTerminated()) {
//            System.out.println("pool not terminate");
        }

        futures.forEach(future -> {
            try {
                System.out.println("future.get() = " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("pool terminate");
    }
}
