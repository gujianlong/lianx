package com.example.zuoye.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:29
 *@Description:
 * */


import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;

public interface Contract {
    interface MyCallBack {
        void onOneSuccess(BeingBean beingBean);

        void onOneError(Throwable throwable);

        void onTwoinSuccess(TwoBean twoBean);

        void onTwoinError(Throwable throwable);

    }

    interface IView {
        void onOneSuccess(BeingBean beingBean);

        void onOneError(Throwable throwable);

        void onTwoinSuccess(TwoBean twoBean);

        void onTwoinError(Throwable throwable);

    }

    interface IModel {
        void getDataOne(MyCallBack myCallBack);

        void getDataTwo(MyCallBack myCallBack);

    }

    interface IPresenter {
        void getDataOne();

        void getDataTwo();


    }
}
