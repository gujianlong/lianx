package com.bawei.zhangsan20191224.app;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:14:02
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
