package com.lsw.prac.tx.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectProxyTest {

    public ReflectProxyTest() {
    }

    String nihao(int i, int j){
        return null;
    }
    Integer nihao(int i){
        return null;
    }

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public String invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };

        Object o = Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, invocationHandler);
        Hello hello = (Hello) o;
        hello.morning("lsw");


    }
}

interface Hello {
    void morning(String name);
    void get();
}
