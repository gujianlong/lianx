package com.example.lianxi2.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:19:37
 *@Description:
 * */


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
        void getInfoNotParams(String url, Class cls, MyCallBack myCallBack);

        void postInfoParams(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoNotParams(String url, Class cls);

        void postInfoParams(String url, Class cls, Map<String, Object> map);
    }
}
