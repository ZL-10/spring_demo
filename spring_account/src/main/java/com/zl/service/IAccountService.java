package com.zl.service;

import com.zl.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * @param
     * @return void
     * 模拟保存保存用户
     *
     */
    void saveAccount();

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
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     * @return void
     *
     *
     */
    void transfer(String sourceName,String targetName,Float money);

}
