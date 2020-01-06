package com.example.gujianlong20200106.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:10:51
 *@Description:
 * */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JsonBean {
    private String json;

    @Generated(hash = 641845262)
    public JsonBean(String json) {
        this.json = json;
    }

    @Generated(hash = 1926928967)
    public JsonBean() {
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
