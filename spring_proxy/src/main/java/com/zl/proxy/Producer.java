package com.zl.proxy;

public class Producer {
    public void saleProduct(float money){
        System.out.println("sold product and get money "+money);
    }

    public void afterService(float money){
        System.out.println("offer afterService and get money "+money);
    }
}
