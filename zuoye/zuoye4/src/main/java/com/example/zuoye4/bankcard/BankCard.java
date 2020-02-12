package com.example.zuoye4.bankcard;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:17:16
 *@Description:
 * */


import java.util.ArrayList;

public class BankCard {
    private String name;
    private int ka;
    private boolean yu;

    public BankCard(String name, int ka, boolean yu) {
        this.name = name;
        this.ka = ka;
        this.yu = yu;
    }
    public void show(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(ka);
        list.add(yu);
    }
}
