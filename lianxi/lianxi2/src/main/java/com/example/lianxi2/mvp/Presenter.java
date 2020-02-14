package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:30
 *@Description:
 * */


import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getReg(String phone, String pwd) {
        iModel.getReg(phone, pwd, new Contract.MyCallBack() {
            @Override
            public void onRegSuccess(RegBean regBean) {
                getView().onRegSuccess(regBean);
            }

            @Override
            public void onRegError(Throwable throwable) {
                getView().onRegError(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginError(Throwable throwable) {
                getView().onLoginError(throwable);
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
    public void getLogin(String phone, String pwd) {
        iModel.getLogin(phone, pwd, new Contract.MyCallBack() {
            @Override
            public void onRegSuccess(RegBean regBean) {
                getView().onRegSuccess(regBean);
            }

            @Override
            public void onRegError(Throwable throwable) {
                getView().onRegError(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginError(Throwable throwable) {
                getView().onLoginError(throwable);
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
    public void getDataOrder(int userId, String sessionId, int status, int page, int count) {
        iModel.getDataOrder(userId, sessionId, status, page, count, new Contract.MyCallBack() {
            @Override
            public void onRegSuccess(RegBean regBean) {
                getView().onRegSuccess(regBean);
            }

            @Override
            public void onRegError(Throwable throwable) {
                getView().onRegError(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginError(Throwable throwable) {
                getView().onLoginError(throwable);
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
