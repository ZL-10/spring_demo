package com.zl.factory;

import com.zl.service.IAccountService;
import com.zl.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private IAccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * @param proxy
             * @param method
             * @param args
             * @return java.lang.Object
             *
             *
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue=null;
                try {
                    txManager.beginTransaction();
                    returnValue=method.invoke(accountService,args);
                    txManager.commit();
                    return returnValue;
                } catch (Exception e) {
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    txManager.release();
                }
            }
        });
    }
}
