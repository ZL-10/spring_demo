package com.zl.service;

import com.zl.domain.Account;

import java.util.List;

public interface IAccountService {


    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);


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
