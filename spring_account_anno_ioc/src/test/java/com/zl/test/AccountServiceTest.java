package com.zl.test;

import com.zl.domain.Account;
import com.zl.service.IAccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    ClassPathXmlApplicationContext ac;
    IAccountService accountService;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean.xml");

        accountService=ac.getBean("accountService",IAccountService.class);

    }

    @After
    public void destroy() {
        ac.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts=accountService.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account=accountService.findAccountById(4);
        System.out.println(account);

    }
    @Test
    public void findSave(){
        Account account=new Account();
        account.setName("test");
        account.setMoney(123f);
        accountService.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        Account account=accountService.findAccountById(4);
        account.setName("update");
        accountService.updateAccount(account);
    }
    @Test
    public void testDelete(){
    accountService.deleteAccount(4);
    }

}
