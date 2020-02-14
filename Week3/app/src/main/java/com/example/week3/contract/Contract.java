package com.example.week3.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:10:49
 *@Description:
 * */


import com.example.week3.bean.CartBean;
import com.example.week3.bean.LoginBean;
import com.example.week3.bean.RegisterBean;

public interface Contract {
    interface MyCallBack {
        void onLoginSuccess(LoginBean loginBean);

        void onloginError(Throwable throwable);

        void onRegisterSuccess(RegisterBean registerBean);

        void onRegisterError(Throwable throwable);

        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);
    }

    interface IVew {
        void onLoginSuccess(LoginBean loginBean);

        void onLoginError(Throwable throwable);

        void onRegisterSuccess(RegisterBean registerBean);

        void onRegisterError(Throwable throwable);

        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);
    }

    interface IModel {
        void postInfoLogin(String phone, String pwd, MyCallBack myCallBack);

        void postInfoRegister(String phone, String pwd, MyCallBack myCallBack);

        void postInfoCart(MyCallBack myCallBack);

    }

    interface IPresenter {
        void postInfoLogin(String phone, String pwd);

        void postInfoRegister(String phone, String pwd);

        void postInfoCart();

    }

}
