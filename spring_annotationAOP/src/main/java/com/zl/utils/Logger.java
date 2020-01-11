package com.zl.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect//表示当前类是切面类
public class Logger {
    @Pointcut(value = "execution(* com.zl.service.impl.*.*(..))")
    private void pt(){}
    /**
     * 前置通知
     */
//    @Before("pt()")
    public void beforePrintLog() {
        System.out.println("前置通知：logger类中的printLog方法开始记录日志");
    }

    /**
     * 后置通知
     */
//    @AfterReturning(pointcut = "pt()")
    public void AfterReturningPrintLog() {
        System.out.println("后置通知：logger类中的AfterReturningPrintLog方法开始记录日志");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing(pointcut = "pt()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：logger类中的afterThrowingPrintLog方法开始记录日志");
    }

    /**
     * 最终通知
     */
//    @After("pt()")
    public void afterPrintLog() {
        System.out.println("最终通知：logger类中的afterPrintLog方法开始记录日志");
    }

    /**
     * 环绕通知
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue=null;
        try{
            Object[] args=proceedingJoinPoint.getArgs();//得到方法运行所需的参数

            System.out.println("前置通知：logger类中的printLog方法开始记录日志");

            returnValue=proceedingJoinPoint.proceed(args);

            System.out.println("后置通知：logger类中的AfterReturningPrintLog方法开始记录日志");


        }catch (Throwable t){
            System.out.println("异常通知：logger类中的afterThrowingPrintLog方法开始记录日志");
        }finally{
            System.out.println("最终通知：logger类中的afterPrintLog方法开始记录日志");
        }
        System.out.println("环绕通知：logger类中的afterPrintLog方法开始记录日志");
        return returnValue;

    }

    ;
}
