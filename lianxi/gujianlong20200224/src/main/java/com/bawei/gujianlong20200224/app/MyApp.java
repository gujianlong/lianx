package com.bawei.gujianlong20200224.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:15
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
