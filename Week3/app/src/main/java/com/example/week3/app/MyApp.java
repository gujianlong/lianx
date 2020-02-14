package com.example.week3.app;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:10:28
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
