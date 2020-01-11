package com.zl.service.impl;


import com.zl.dao.IAccountDao;
import com.zl.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {
 private String name;
 private Integer age;
 private Date birthday;
 private IAccountDao accountDao;

 public AccountServiceImpl(String name, Integer age, Date birthday, IAccountDao accountDao) {
  this.name = name;
  this.age = age;
  this.birthday = birthday;
  this.accountDao = accountDao;
 }

 public void saveAccount() {
  System.out.println("run accountService.saveAccount()"+name+age+birthday);
 }
}
