package com.example.week3.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:11:01
 *@Description:
 * */


import com.example.week3.base.BasePresenter;
import com.example.week3.bean.CartBean;
import com.example.week3.bean.LoginBean;
import com.example.week3.bean.RegisterBean;
import com.example.week3.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void postInfoLogin(String phone, String pwd) {
        iModel.postInfoLogin(phone, pwd, new Contract.MyCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onloginError(Throwable throwable) {
                getView().onLoginError(throwable);
            }

            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                getView().onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterError(Throwable throwable) {
                getView().onRegisterError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }
        });
    }

    @Override
    public void postInfoRegister(String phone, String pwd) {
        iModel.postInfoRegister(phone, pwd, new Contract.MyCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onloginError(Throwable throwable) {
                getView().onLoginError(throwable);
            }

            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                getView().onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterError(Throwable throwable) {
                getView().onRegisterError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }
        });
    }

    @Override
    public void postInfoCart() {
        iModel.postInfoCart(new Contract.MyCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onloginError(Throwable throwable) {
                getView().onLoginError(throwable);
            }

            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                getView().onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterError(Throwable throwable) {
                getView().onRegisterError(throwable);
            }

            @Override
            public void onCartSuccess(CartBean cartBean) {
                getView().onCartSuccess(cartBean);
            }

            @Override
            public void onCartError(Throwable throwable) {
                getView().onCartError(throwable);
            }
        });
    }
}
