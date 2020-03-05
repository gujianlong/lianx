package com.bawei.gujianlong2020218.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:10:03
 *@Description:
 * */


import com.bawei.gujianlong2020218.base.BasePresenter;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new Model();
    }

    @Override
    public void getShowData(String keyword, int page, int count) {
        iModel.getShowData(keyword, page, count, new Contract.MyCallBack() {
            @Override
            public void onShowSuccess(ShowBean showBean) {
                getView().onShowSuccess(showBean);
            }

            @Override
            public void onShowError(Throwable throwable) {
                getView().onShowError(throwable);
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
    public void getOrderData(int userId, String sessionId, int status, int page, int count) {
        iModel.getOrderData(userId, sessionId, status, page, count, new Contract.MyCallBack() {
            @Override
            public void onShowSuccess(ShowBean showBean) {
                getView().onShowSuccess(showBean);
            }

            @Override
            public void onShowError(Throwable throwable) {
                getView().onShowError(throwable);
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
