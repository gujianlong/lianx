package com.bawei.gujianlong2020218.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:9:32
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
