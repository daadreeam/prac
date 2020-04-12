package com.lsw.prac.tx.reflect;

import java.util.concurrent.RunnableFuture;

public class ReflectInheritTest {
    public static void main(String[] args) throws Exception {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());

//        Class s = RunnableFuture.class;
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class ii : is) {
            System.out.println(ii);
        }
    }
}
