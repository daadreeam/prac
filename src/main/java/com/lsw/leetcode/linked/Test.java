package com.lsw.leetcode.linked;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("hhhhh");
        } catch (RuntimeException e) {
            String string = e.toString();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println("stackTraceElement = " + stackTraceElement);
            }
            for (StackTraceElement traceElement : stackTrace)
                System.out.println("\tat " + traceElement);


            String string1 = stackTrace.toString();
            System.out.println("string = " + string);
            System.out.println("string1 = " + string1);
            System.out.println("e.getCause() = " + e.getCause());
            System.out.println("e = " + e);
            String localizedMessage = e.getLocalizedMessage();
            e.printStackTrace();
        }
    }
}
