package com.zl.service.impl;

import com.zl.dao.IAccountDao;
import com.zl.factory.BeanFactory;
import com.zl.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        System.out.println("run AccountServiceImpl.saveAccount()");
        accountDao.saveAccount();
    }
}
