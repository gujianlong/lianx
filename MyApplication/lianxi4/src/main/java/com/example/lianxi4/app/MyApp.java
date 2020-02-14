package com.example.lianxi4.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/23
 *@Time:8:51
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
