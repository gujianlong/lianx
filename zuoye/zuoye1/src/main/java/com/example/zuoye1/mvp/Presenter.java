package com.example.zuoye1.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:48
 *@Description:
 * */


import com.example.zuoye1.base.BasePresenter;
import com.example.zuoye1.bean.CartBean;
import com.example.zuoye1.bean.LoginBean;
import com.example.zuoye1.bean.RegisterBean;
import com.example.zuoye1.contract.Contract;

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
            public void onLoginError(Throwable throwable) {
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
            public void onLoginError(Throwable throwable) {
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
            public void onLoginError(Throwable throwable) {
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
