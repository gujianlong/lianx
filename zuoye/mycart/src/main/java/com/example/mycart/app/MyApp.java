package com.example.mycart.app;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:00
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
