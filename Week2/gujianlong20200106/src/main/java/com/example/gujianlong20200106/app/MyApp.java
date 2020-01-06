package com.example.gujianlong20200106.app;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:8:54
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
