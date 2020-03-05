package com.example.zuoye.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:05
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
