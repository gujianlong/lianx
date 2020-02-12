package com.example.zuoye2.myjava;
/*
 *@auther:谷建龙
 *@Date: 2020/1/17
 *@Time:11:00
 *@Description:
 * */


import android.icu.text.CaseMap;

public class Account {
    private int id;
    private String name;
    private float money;

    public float saveMoney() {
        money = 200;
        return money;
    }

    public float withDrawMoney() {
        money = 100;
        return money;
    }


    public Account(int id, String name, float money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float isMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
