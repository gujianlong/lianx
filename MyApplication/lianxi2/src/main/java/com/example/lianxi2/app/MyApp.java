package com.example.lianxi2.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:13:47
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
