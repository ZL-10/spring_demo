package com.zl.ui;


import com.zl.dao.IAccountDao;
import com.zl.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {


    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据对象id获取对象
        IAccountService service=(IAccountService)ac.getBean("accountService");
        IAccountDao dao=(IAccountDao)ac.getBean("accountDao");

        System.out.println(service);
        System.out.println(dao);
    }
}
