package com.zl.test;

import com.zl.service.IAccountService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=(IAccountService)ac.getBean("accountService");
        accountService.saveAccount();
        accountService.deleteAccount();
        accountService.updateAccount(1);
    }
}
