package com.example.zuoye3.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:25
 *@Description:
 * */


import com.example.zuoye3.bean.OrderBean;

public interface Contract {
    interface MyCallBack {
        void SuccessionOrder(OrderBean orderBean);

        void ErrorOrder(Throwable throwable);
    }

    interface IView {
        void SuccessionOrder(OrderBean orderBean);

        void ErrorOrder(Throwable throwable);
    }

    interface IModel {
        void getInfo(int status, int page, int count, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfo(int status, int page, int count);
    }
}
