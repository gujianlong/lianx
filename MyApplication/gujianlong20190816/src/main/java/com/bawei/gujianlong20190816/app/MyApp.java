package com.bawei.gujianlong20190816.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:07
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
