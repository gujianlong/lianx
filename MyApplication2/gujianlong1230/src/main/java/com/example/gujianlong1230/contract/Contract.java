package com.example.gujianlong1230.contract;
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

        void getInfoParam(String url, Map<String, Object> map, Class cls, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfo(String url, Class cls);

        void getInfoParam(String url, Map<String, Object> map, Class cls);
    }

}
