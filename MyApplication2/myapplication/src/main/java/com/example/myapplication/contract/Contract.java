package com.example.myapplication.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:57
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
        void getInfo(String url, Class cls, MyCallBack myCallBack);

        void postInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfo(String url, Class cls);

        void postInfo(String url, Class cls, Map<String, Object> map);
    }

}
