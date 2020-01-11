package com.zl.service.impl;


import com.zl.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl2 implements IAccountService {
 private String name;
 private Integer age;
 private Date birthday;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public Date getBirthday() {
  return birthday;
 }

 public void setBirthday(Date birthday) {
  this.birthday = birthday;
 }

 public void saveAccount() {
  System.out.println("run accountService.saveAccount()"+name+age+birthday);
 }
}
