package com.example.myapplication2.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:19:51
 *@Description:
 * */


import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
