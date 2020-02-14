package com.bawei.zhangsan20191224.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/24
 *@Time:14:20
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
        void onGetInfo(String url, Class cls, MyCallBack myCallBack);

        void onPostInfo(String url, Class cls, Map<String, Object> map, MyCallBack myCallBack);
    }

    interface IPresenter {
        void onGetInfo(String url, Class cls);

        void onPostInfo(String url, Class cls, Map<String, Object> map);
    }

}
