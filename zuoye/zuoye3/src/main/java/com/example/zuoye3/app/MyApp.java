package com.example.zuoye3.app;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:08
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
