package com.lsw.prac.myconcurrent;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现自己的aqs同步器
 */
@Data
public class MyLock {

    // 当前占用锁的线程数
    private volatile int state;
    // 当前持有锁的线程
    private Thread lockHolder;

    // 创建一个队列来存应该要等待的线程
    private static ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    // 是否取锁成功
    private boolean aquire(){

        Thread currentThread = Thread.currentThread();

        // 如果加锁成功
        if (state == 0 ) {
            // todo
            // 预期
            int expect = 0;
            // 期望
            int update = 1;

            // todo 重要 size=0 对应新来的，currentThread == waiters.peek() 对应刚被唤醒的
            if ( (waiters.size() == 0 || currentThread == waiters.peek())
                    && compareAndSet(expect, update)) {
                // 原子操作 state
//            boolean b = unsafe.compareAndSwapInt(this, stateOffset, expect, update);
                lockHolder = Thread.currentThread();
                return true;
            }
        }
        return false;
    }

    // lock
    public void lock(){
        // 加锁成功
        if (aquire()) {
            return;
        }
        Thread currentThread = Thread.currentThread();
        // 没有得到锁的线程 就入队
        // 当前线程入队等待
        waiters.add(currentThread);
        for (;;) {
            // 尝试获得
            if ( currentThread == waiters.peek() && aquire()) {
                // 得到锁就跳出循环
                // todo 将队列的头部元素推出队头
                waiters.poll();
                return;
            }

            LockSupport.park(currentThread);
        }

    }

    // unlock
    public void unlock(){
        // todo 要判断一下当前线程是否是锁的持有者
        Thread currentThread = Thread.currentThread();
        if (currentThread == lockHolder) {
            int expect = 1;
            int update = 0;
            // state 改为0
            if (compareAndSet(expect, update)) {
                lockHolder = null;
                // 如果排队的线程不为空，就唤醒第一个排队的线程
                Thread headThread = waiters.peek();
                if (headThread != null) {
//                    Thread headThread = waiters.poll();
                    // todo 这里不要用poll等到抢了之后再用poll
                    // todo 这里可能会出现问题，就是当poll之后，如果有新线程要去加锁的话，会抢得到，这样的顺序就不一样了
                    // 唤醒阻塞的线程去修改state
                    LockSupport.unpark(headThread);
                }
            }
        } else {
            throw new RuntimeException("当前解锁线程不是持有锁的线程");
        }
    }

    /**
     * 通过反射得到unsafe对象
     * @return
     */
    public static Unsafe reflectGetUnsafe() {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            Object o = theUnsafeField.get(null);
            return (Unsafe) o;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

//    private static long stateOffset;
//    private static Unsafe unsafe = reflectGetUnsafe();

    // 得到state变量的在内存中的偏移量
    public static long getStateOffset() throws NoSuchFieldException {
        Field stateField = MyLock.class.getDeclaredField("state");
        return unsafe.objectFieldOffset(stateField);
    }

    public final boolean compareAndSet(int expect, int update){
        boolean b = unsafe.compareAndSwapInt(this, stateOffset,expect, update);
        return b;
    }


    private static long stateOffset = 0;
    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();

    static {
        try {
            assert unsafe != null;
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出错了");
        }
    }
}
