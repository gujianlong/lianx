package com.bawei.gujianlong2020218.contract;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:9:55
 *@Description:
 * */


import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;

public interface Contract {
    interface MyCallBack {
        void onShowSuccess(ShowBean showBean);

        void onShowError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IView {
        void onShowSuccess(ShowBean showBean);

        void onShowError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IModel {
        void getShowData(String keyword, int page, int count, MyCallBack myCallBack);

        void getOrderData(int userId, String sessionId, int status, int page, int count, MyCallBack myCallBack);
    }

    interface IPresenter {
        void getShowData(String keyword, int page, int count);

        void getOrderData(int userId, String sessionId, int status, int page, int count);
    }
}
