package com.example.lianxi2.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:29
 *@Description:
 * */


import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;

import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Contract {
    interface MyCallBack {
        void onRegSuccess(RegBean regBean);

        void onRegError(Throwable throwable);

        void onLoginSuccess(LoginBean loginBean);

        void onLoginError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IView {
        void onRegSuccess(RegBean regBean);

        void onRegError(Throwable throwable);

        void onLoginSuccess(LoginBean loginBean);

        void onLoginError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IModel {
        void getReg(String phone, String pwd, MyCallBack myCallBack);

        void getLogin(String phone, String pwd, MyCallBack myCallBack);

        void getDataOrder(int userId, String sessionId, int status, int page, int count, MyCallBack myCallBack);

    }

    interface IPresenter {
        void getReg(String phone, String pwd);

        void getLogin(String phone, String pwd);

        void getDataOrder(int userId, String sessionId, int status, int page, int count);

    }
}
