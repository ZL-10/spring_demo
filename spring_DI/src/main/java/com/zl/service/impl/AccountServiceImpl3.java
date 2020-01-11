package com.zl.service.impl;


import com.zl.service.IAccountService;

import java.util.*;


public class AccountServiceImpl3 implements IAccountService {
 private  String[] strs;
 private List<String> list;
 private Set<String> set;
 private Map<String,String> map;
 private Properties properties;

 public String[] getStrs() {
  return strs;
 }

 public void setStrs(String[] strs) {
  this.strs = strs;
 }

 public List<String> getList() {
  return list;
 }

 public void setList(List<String> list) {
  this.list = list;
 }

 public Set<String> getSet() {
  return set;
 }

 public void setSet(Set<String> set) {
  this.set = set;
 }

 public Map<String, String> getMap() {
  return map;
 }

 public void setMap(Map<String, String> map) {
  this.map = map;
 }

 public Properties getProperties() {
  return properties;
 }

 public void setProperties(Properties properties) {
  this.properties = properties;
 }

 public void saveAccount() {

  System.out.println(Arrays.toString(strs));
  System.out.println(list);
  System.out.println(set);
  System.out.println(map);
  System.out.println(properties);
 }
}
