package com.zl.dao.impl;

import com.zl.dao.IAccountDao;
import com.zl.domain.Account;
import com.zl.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {

    }

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtil;



    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtil.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtil.getThreadConnection(),"select * from account where id = ? ", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"delete from account where id=?", accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts=null;
        try{
            accounts=runner.query(connectionUtil.getThreadConnection(),"select * from account where name=?",new BeanListHandler<Account>(Account.class),accountName);
            if (accounts==null||accounts.size()==0){
                return null;
            }
            if(accounts.size()>1){
                throw new RuntimeException(("账户不唯一"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return accounts.get(0);
    }
}
