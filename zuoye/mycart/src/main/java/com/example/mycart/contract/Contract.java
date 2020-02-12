package com.example.mycart.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:17
 *@Description:
 * */


import com.example.mycart.bean.CartBean;

public interface Contract {
    interface MyCallBack {
        void mySuccessCart(CartBean cartBean);

        void myErrorCart(Throwable throwable);
    }

    interface IView {
        void mySuccessCart(CartBean cartBean);

        void myErrorCart(Throwable throwable);
    }

    interface IModel {
        void getDataCart(int userId, String sessionId, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getDataCart(int userId, String sessionId);
    }

}
