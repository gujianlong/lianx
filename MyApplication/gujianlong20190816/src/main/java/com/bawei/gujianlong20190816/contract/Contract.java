package com.bawei.gujianlong20190816.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:43
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
        void onGetInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);

        void onPostInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void onGetInfo(String url, Class cls, Map<String, Object> map);

        void onPostInfo(String url, Class cls, Map<String, Object> map);
    }
}
