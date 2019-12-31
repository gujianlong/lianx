package com.bawei.gujianlong20191231.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:8:57
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
