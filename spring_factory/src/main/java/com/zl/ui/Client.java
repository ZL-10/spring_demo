package com.zl.ui;

import com.zl.factory.BeanFactory;
import com.zl.service.IAccountService;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            //accountService.saveAccount();
        }

    }
}
