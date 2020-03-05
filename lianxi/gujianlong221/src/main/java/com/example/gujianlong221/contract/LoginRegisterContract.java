package com.example.gujianlong221.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:44
 *@Description:
 * */


import android.widget.ImageView;

import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.bean.UserBean;

public interface LoginRegisterContract {
    interface MyCallBack {
        void onLoginSuccess(LoginBean loginBean);

        void onLoginError(Throwable throwable);

        void onRegSuccess(RegBean regBean);

        void onRegError(Throwable throwable);

        void onUserSuccess(UserBean userBean);

        void onUserError(Throwable throwable);
    }

    interface IView {
        void onLoginSuccess(LoginBean loginBean);

        void onLoginError(Throwable throwable);

        void onRegSuccess(RegBean regBean);

        void onRegError(Throwable throwable);

        void onUserSuccess(UserBean userBean);

        void onUserError(Throwable throwable);
    }

    interface IModel {
        void getDataLogin(String phone, String pwd, MyCallBack myCallBack);

        void getDataReg(String phone, String pwd, MyCallBack myCallBack);

        void getDataUser(MyCallBack myCallBack);
    }

    interface IPresenter {
        void getDataLogin(String phone, String pwd);

        void getDataUser();

        void getDataReg(String phone, String pwd);
    }
}
