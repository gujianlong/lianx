package com.example.lianxi.bean;
/*
 *@auther:谷建龙
 *@Date: 2019/12/29
 *@Time:19:39
 *@Description:
 * */


public class Beanl {
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

    public Beanl(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
