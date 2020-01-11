package com.zl.test;

import com.zl.domain.Account;
import com.zl.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier(value = "proxyAccountService")
    IAccountService accountService;

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

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }

}
