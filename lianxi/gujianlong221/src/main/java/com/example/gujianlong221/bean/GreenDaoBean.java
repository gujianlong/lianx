package com.example.gujianlong221.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/3/5
 *@Time:17:01
 *@Description:
 * */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenDaoBean {
    private String json;

    @Generated(hash = 1448085285)
    public GreenDaoBean(String json) {
        this.json = json;
    }

    @Generated(hash = 826843181)
    public GreenDaoBean() {
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
