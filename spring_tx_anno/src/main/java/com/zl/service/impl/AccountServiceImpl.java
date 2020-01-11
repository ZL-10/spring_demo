package com.zl.service.impl;


import com.zl.dao.IAccountDao;
import com.zl.domain.Account;
import com.zl.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author zl
 * <bean id="accountService" class="com.zl.service.impl.AccountServiceImpl"></bean>
 */

@Service(value = "accountService")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public AccountServiceImpl() {

    }



    public Account findAccountById(Integer accountId) {
        Account account = accountDao.findAccountById(accountId);
        return account;
    }



    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
//        int i=1/0;
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}