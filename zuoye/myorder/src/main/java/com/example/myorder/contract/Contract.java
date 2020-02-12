package com.example.myorder.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:33
 *@Description:
 * */


import com.example.myorder.bean.OrderBean;

public interface Contract {
    interface MyCallBack {
        void getOrderSuccess(OrderBean orderBean);

        void getOrderError(Throwable throwable);
    }

    interface IView {
        void getOrderSuccess(OrderBean orderBean);

        void getOrderError(Throwable throwable);
    }

    interface IModel {
        void getOrderData(int userId, String sessionId, int status, int page, int count, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getOrderData(int userId, String sessionId, int status, int page, int count);
    }

}
