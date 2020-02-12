package com.example.zuoye5.app;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:21
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
