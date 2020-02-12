package com.example.myorder.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:14
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
