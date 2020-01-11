package com.zl.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtil;

    @Pointcut("execution(* com.zl.service.impl.*.*(..))")
    private void pt(){}


//    @Before("pt()")
    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterReturning("pt()")
    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @AfterThrowing("pt()")
    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @After("pt()")
    public void release() {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Around("pt()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue=null;
        try{
            Object[] args=proceedingJoinPoint.getArgs();

            this.beginTransaction();
            //执行方法
            returnValue=proceedingJoinPoint.proceed(args);

            this.commit();

        }catch (Throwable t){
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            this.release();
        }
        return returnValue;
    }
}
