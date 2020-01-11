package com.zl.dao.impl;

import com.zl.dao.IAccountDao;
import com.zl.domain.Account;
import com.zl.mapper.AccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountById(Integer accountId) {
        try {
            return (Account) getJdbcTemplate().query("select * from account where id = ?",new AccountRowMapper(),accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public Account findAccountByName(String accountName) {
        List<Account> accounts=null;
        try{

            accounts=getJdbcTemplate().query("select * from account where name=?",new AccountRowMapper(),accountName);
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

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set money=? where id=?",account.getMoney(),account.getId());
    }


}
