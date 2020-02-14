package com.example.lianxi.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/14
 *@Time:11:37
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContent;

    @Override
    public void onCreate() {
        super.onCreate();
        mContent = this;
    }
}
