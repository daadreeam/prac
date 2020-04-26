package com.lsw.prac.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * // pointcut + advice = aspect
 * // https://www.cnblogs.com/Struts-pring/p/9881716.html execution 表达式详解
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 定义pointcut
     */
    @Pointcut("execution(* com.lsw.prac.controller..*.*(..))")
    public void controllerPointcut(){}

    /**
     * 定义通知
      */
    @Around("controllerPointcut()")
    public Object advice(ProceedingJoinPoint joinPoint){
        System.out.println("通知 方法执行前");

        Object proceed = null;

        String name = joinPoint.getTarget().getClass().getName();
        System.out.println( "通知 target类名" + name);
        try {
            // 真正的方法执行
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Signature signature = joinPoint.getSignature();
        System.out.println("signature.getName() = " + signature.getName());
        System.out.println("signature.getDeclaringType() = " + signature.getDeclaringType());
        System.out.println("signature.getDeclaringTypeName() = " + signature.getDeclaringTypeName());
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));


        System.out.println("通知 方法执行后");
        System.out.println("joinPoint.getKind() = " + joinPoint.getKind());
        System.out.println("joinPoint.getSourceLocation() = " + joinPoint.getSourceLocation());

        // 必须得加上不然没得响应
        return proceed;
    }
}
