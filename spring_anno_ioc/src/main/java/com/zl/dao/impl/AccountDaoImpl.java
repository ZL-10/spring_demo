package com.zl.dao.impl;

import com.zl.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("run AccountDaoImpl.saveAccount()1111111111111");
    }
}
