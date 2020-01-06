package com.example.week.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:57
 *@Description:
 * */


import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;

import java.util.Map;

public interface Contract {
    interface MyCallBack {
        void onClassSuccess(UserBean url);

        void onClassError(Throwable throwable);

        void onCommitSuccess(ItemBean url);

        void onCommitError(Throwable throwable);
    }

    interface IView {
        void onClassSuccess(UserBean url);

        void onClassError(Throwable throwable);

        void onCommitSuccess(ItemBean url);

        void onCommitError(Throwable throwable);
    }

    interface IModel {
        void getInfo(MyCallBack myCallBack);

        void getInfoParams(String stringId, MyCallBack myCallBack);

    }

    interface IPresenter {
        void getInfo();

        void getInfoParams(String stringId);
    }
}
