package com.example.zuoye4.person;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:17:22
 *@Description:
 * */


public class NorthPerson extends Person{
    private String name;
    private int age;
    private String chi;

    @Override
    public String toString() {
        return "NorthPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", chi='" + chi + '\'' +
                '}';
    }

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

    public String getChi() {
        return chi;
    }

    public void setChi(String chi) {
        this.chi = chi;
    }

    public NorthPerson(String name, int age, String chi) {
        this.name = name;
        this.age = age;
        this.chi = chi;
    }
}
