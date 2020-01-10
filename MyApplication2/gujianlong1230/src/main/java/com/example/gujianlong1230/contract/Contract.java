package com.example.gujianlong1230.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:57
 *@Description:
 * */


import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;

import java.util.Map;

public interface Contract {
    interface MyCallBack {
        void onHomeSuccess(UserBean userBean);

        void onHomeError(Throwable throwable);

        void onBannerSuccess(BannerBean bannerBean);

        void onBannerError(Throwable throwable);

        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);

        void onDingSuccess(DingBean dingBean);

        void onDingError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IView {
        void onHomeSuccess(UserBean userBean);

        void onHomeError(Throwable throwable);

        void onBannerSuccess(BannerBean bannerBean);

        void onBannerError(Throwable throwable);

        void onCartSuccess(CartBean cartBean);

        void onCartError(Throwable throwable);

        void onDingSuccess(DingBean dingBean);

        void onDingError(Throwable throwable);

        void onOrderSuccess(OrderBean orderBean);

        void onOrderError(Throwable throwable);
    }

    interface IModel {
        void getInfoBanner(MyCallBack myCallBack);

        void getInfo(MyCallBack myCallBack);

        void getInfoParam(MyCallBack myCallBack);

        void getInfoParamDing(MyCallBack myCallBack);

        void getInfoParamOrder(int status, int page, int count, MyCallBack myCallBack);


    }

    interface IPresenter {
        void getInfoBanner();

        void getInfo();

        void getInfoParam();

        void getInfoParamDing();

        void getInfoParamOrder(int status, int page, int count);
    }

}
