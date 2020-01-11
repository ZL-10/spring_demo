package com.zl.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知：logger类中的printLog方法开始记录日志");
    }

    /**
     * 后置通知
     */
    public void AfterReturningPrintLog() {
        System.out.println("后置通知：logger类中的AfterReturningPrintLog方法开始记录日志");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：logger类中的afterThrowingPrintLog方法开始记录日志");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知：logger类中的afterPrintLog方法开始记录日志");
    }

    /**
     * 环绕通知
     */
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
