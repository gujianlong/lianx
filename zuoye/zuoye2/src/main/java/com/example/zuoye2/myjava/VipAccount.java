package com.example.zuoye2.myjava;
/*
 *@auther:谷建龙
 *@Date: 2020/1/17
 *@Time:11:06
 *@Description:
 * */


import android.graphics.ColorSpace;
import android.widget.Toast;

public class VipAccount extends Account {
    public VipAccount(int id, String name, float money) {
        super(id, name, money);
    }

    public float bigWithDrawMoney() {
        float money = 0;
        if (money > 5000) {
            System.out.println("出款成功");
        } else {
            System.out.println("余额不足");
        }
        return money;
    }
}
