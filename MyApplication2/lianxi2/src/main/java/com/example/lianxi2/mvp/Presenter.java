package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:17
 *@Description:
 * */


import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }


    @Override
    public void getInfoParams() {
        iModel.getInfoParams( new Contract.MyCallBack() {
            @Override
            public void onClassSuccess(UserBean userBean) {
                getView().onClassSuccess(userBean);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
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
    public void getInfoParamsOrser(int count, int page, int status) {
        iModel.getInfoParamsOrder(count, page, status, new Contract.MyCallBack() {
            @Override
            public void onClassSuccess(UserBean userBean) {
                getView().onClassSuccess(userBean);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
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
