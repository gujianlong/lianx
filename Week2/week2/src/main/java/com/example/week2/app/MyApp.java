package com.example.week2.app;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:9:42
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
