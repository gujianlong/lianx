package com.example.myapplication.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:14:03
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
        void getInfo(String url, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfo(String url);
    }
}
