package com.zl.service.impl;


import com.zl.dao.IAccountDao;
import com.zl.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author zl
 * <bean id="accountService" class="com.zl.service.impl.AccountServiceImpl"></bean>
 */
@Component(value = "accountService")
@Scope(value = "singleton")

public class AccountServiceImpl implements IAccountService {
    //    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("new AccountService()");
    }

    @PostConstruct
    public void init() {
        System.out.println("init AccountServiceImpl()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy AccountServiceImpl()");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}