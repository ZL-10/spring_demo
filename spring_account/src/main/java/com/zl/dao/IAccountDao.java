package com.zl.dao;

import com.zl.domain.Account;

import java.util.List;

public interface IAccountDao {


    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

    /**
     * @param accountName
     * @return com.zl.domain.Account
     * 根据用户名查询
     *
     */
    Account findAccountByName(String accountName);

    void saveAccount();
}
