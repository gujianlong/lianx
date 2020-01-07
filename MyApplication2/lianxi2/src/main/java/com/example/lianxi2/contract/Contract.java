package com.example.lianxi2.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:10
 *@Description:
 * */


import com.example.lianxi2.bean.UserBean;

public interface Contract {
    interface MyCallBack {
        void onClassSuccess(UserBean userBean);

        void onClassError(Throwable throwable);

    }

    interface IView {
        void onClassSuccess(UserBean homeBean);

        void onClassError(Throwable throwable);

    }

    interface IModel {
        void getInfoParams(MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoParams();
    }
}
