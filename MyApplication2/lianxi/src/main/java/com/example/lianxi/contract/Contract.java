package com.example.lianxi.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/28
 *@Time:13:45
 *@Description:
 * */


public interface Contract {
    interface MyCallBack {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    interface IView {
        void onSuccess(String url);

        void onError(Throwable throwable);
    }

    interface IModel {
        void getInfoParams(String url, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoParams(String url);
    }
}
