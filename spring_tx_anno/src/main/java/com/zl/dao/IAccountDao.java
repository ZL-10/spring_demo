package com.zl.dao;

import com.zl.domain.Account;

import java.util.List;

public interface IAccountDao {


    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);


    /**
     * @param accountName
     * @return com.zl.domain.Account
     * 根据用户名查询
     *
     */
    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
