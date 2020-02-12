package com.example.zuoye5.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:37
 *@Description:
 * */


import com.example.zuoye5.bean.CartBean;

public interface Contract {
    interface MyCallBack {
        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);
    }

    interface IView {
        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);
    }

    interface IModel {
        void postInfoCart(MyCallBack myCallBack);
    }

    interface IPresenter {
        void postInfoCart();
    }
}
