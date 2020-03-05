package com.example.gujianlong221.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/28
 *@Time:16:49
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
