package com.example.gujianlong20200106.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:10
 *@Description:
 * */


import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;

public interface Contract {
    interface MyCallBack {
        void onClassSuccess(HomeBean homeBean);

        void onClassError(Throwable throwable);

        void onCommitSuccess(ItemBean itemBean);

        void onCommitError(Throwable throwable);
    }

    interface IView {
        void onClassSuccess(HomeBean homeBean);

        void onClassError(Throwable throwable);

        void onCommitSuccess(ItemBean itemBean);

        void onCommitError(Throwable throwable);
    }

    interface IModel {
        void getInfoNo(MyCallBack myCallBack);

        void getInfoParams(String url, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getInfoNo();

        void getInfoParams(String url);
    }
}
