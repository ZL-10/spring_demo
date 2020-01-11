package com.zl.factory;

import com.zl.service.IAccountService;
import com.zl.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
