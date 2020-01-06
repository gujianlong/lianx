package com.example.week2.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:9:53
 *@Description:
 * */


import com.example.week2.bean.ItemBean;
import com.example.week2.bean.UserBean;

public interface Contract {
    interface MyCallBack {
        void onCalssSuccess(UserBean userBean);

        void onCalssError(Throwable throwable);

        void onCommitSuccess(ItemBean itemBean);

        void onCommitError(Throwable throwable);
    }

    interface IView {
        void onCalssSuccess(UserBean userBean);

        void onCalssError(Throwable throwable);

        void onCommitSuccess(ItemBean itemBean);

        void onCommitError(Throwable throwable);
    }

    interface IModel {
        void getInfoNo(MyCallBack myCallBack);

        void getInfoParams(String stringId, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoNo();

        void getInfoParams(String stringId);
    }
}
