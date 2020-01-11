package com.zl.service.impl;


import com.zl.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
 public AccountServiceImpl() {
  System.out.println("new AccountServiceImpl");
 }

 public void saveAccount() {
  System.out.println("run accountService.saveAccount(");
 }

 public void init(){
  System.out.println("run accountService.init()");
 }

 public void destroy(){
  System.out.println("run accountService.destroy()");
 }
}