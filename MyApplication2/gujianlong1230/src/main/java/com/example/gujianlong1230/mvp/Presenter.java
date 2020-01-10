package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:00
 *@Description:
 * */


import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.contract.Contract;
import com.example.gujianlong1230.utils.NetUtils;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }


    @Override
    public void getInfoBanner() {
        iModel.getInfoBanner(new Contract.MyCallBack() {
            @Override
            public void onHomeSuccess(UserBean userBean) {
                getView().onHomeSuccess(userBean);
            }

            @Override
            public void onHomeError(Throwable throwable) {
                getView().onHomeError(throwable);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(Throwable throwable) {
                getView().onBannerError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }

            @Override
            public void onDingSuccess(DingBean dingBean) {
                getView().onDingSuccess(dingBean);
            }

            @Override
            public void onDingError(Throwable throwable) {
                getView().onDingError(throwable);
            }

            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderError(Throwable throwable) {
                getView().onOrderError(throwable);
            }
        });
    }

    @Override
    public void getInfo() {
        iModel.getInfo(new Contract.MyCallBack() {
            @Override
            public void onHomeSuccess(UserBean userBean) {
                getView().onHomeSuccess(userBean);
            }

            @Override
            public void onHomeError(Throwable throwable) {
                getView().onHomeError(throwable);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(Throwable throwable) {
                getView().onBannerError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }

            @Override
            public void onDingSuccess(DingBean dingBean) {
                getView().onDingSuccess(dingBean);
            }

            @Override
            public void onDingError(Throwable throwable) {
                getView().onDingError(throwable);
            }

            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderError(Throwable throwable) {
                getView().onOrderError(throwable);
            }
        });
    }

    @Override
    public void getInfoParam() {
        iModel.getInfoParam(new Contract.MyCallBack() {
            @Override
            public void onHomeSuccess(UserBean userBean) {
                getView().onHomeSuccess(userBean);
            }

            @Override
            public void onHomeError(Throwable throwable) {
                getView().onHomeError(throwable);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(Throwable throwable) {
                getView().onBannerError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }

            @Override
            public void onDingSuccess(DingBean dingBean) {
                getView().onDingSuccess(dingBean);
            }

            @Override
            public void onDingError(Throwable throwable) {
                getView().onDingError(throwable);
            }

            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderError(Throwable throwable) {
                getView().onOrderError(throwable);
            }
        });
    }

    @Override
    public void getInfoParamDing() {
        iModel.getInfoParamDing(new Contract.MyCallBack() {
            @Override
            public void onHomeSuccess(UserBean userBean) {
                getView().onHomeSuccess(userBean);
            }

            @Override
            public void onHomeError(Throwable throwable) {
                getView().onHomeError(throwable);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(Throwable throwable) {
                getView().onBannerError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }

            @Override
            public void onDingSuccess(DingBean dingBean) {
                getView().onDingSuccess(dingBean);
            }

            @Override
            public void onDingError(Throwable throwable) {
                getView().onDingError(throwable);
            }

            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderError(Throwable throwable) {
                getView().onOrderError(throwable);
            }
        });
    }

    @Override
    public void getInfoParamOrder(int status, int page, int count) {
        iModel.getInfoParamOrder(status, page, count, new Contract.MyCallBack() {
            @Override
            public void onHomeSuccess(UserBean userBean) {
                getView().onHomeSuccess(userBean);
            }

            @Override
            public void onHomeError(Throwable throwable) {
                getView().onHomeError(throwable);
            }

            @Override
            public void onBannerSuccess(BannerBean bannerBean) {
                getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void onBannerError(Throwable throwable) {
                getView().onBannerError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }

            @Override
            public void onDingSuccess(DingBean dingBean) {
                getView().onDingSuccess(dingBean);
            }

            @Override
            public void onDingError(Throwable throwable) {
                getView().onDingError(throwable);
            }

            @Override
            public void onOrderSuccess(OrderBean orderBean) {
                getView().onOrderSuccess(orderBean);
            }

            @Override
            public void onOrderError(Throwable throwable) {
                getView().onOrderError(throwable);
            }
        });
    }

}
