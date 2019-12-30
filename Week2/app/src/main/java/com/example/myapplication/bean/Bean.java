package com.example.myapplication.bean;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:15:43
 *@Description:
 * */


public class Bean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
