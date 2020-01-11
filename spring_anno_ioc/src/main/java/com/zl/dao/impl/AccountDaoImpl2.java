package com.zl.dao.impl;

import com.zl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount() {
        System.out.println("run AccountDaoImpl.saveAccount()22222222222222222");
    }
}
