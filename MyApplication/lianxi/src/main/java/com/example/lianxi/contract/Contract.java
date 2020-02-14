package com.example.lianxi.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/15
 *@Time:14:29
 *@Description:
 * */


import com.example.lianxi.app.MyApp;

import java.util.Map;

public interface Contract {
    interface MyCallBack<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IView<T> {
        void onSuccess(T t);

        void onError(String error);
    }

    interface IModel {
        void getInfoPramars(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);

        void postInfoPramars(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoPramars(String url, Class cls, Map<String, Object> map);

        void postInfoPramars(String url, Class cls, Map<String, Object> map);
    }
}
