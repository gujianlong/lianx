package com.bawei.gujianlong2020218.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:9:25
 *@Description:
 * */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JsonSqlite {
    @Id(autoincrement = true)
    Long id;
    String json;
    @Generated(hash = 489908297)
    public JsonSqlite(Long id, String json) {
        this.id = id;
        this.json = json;
    }
    @Generated(hash = 1890786739)
    public JsonSqlite() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
