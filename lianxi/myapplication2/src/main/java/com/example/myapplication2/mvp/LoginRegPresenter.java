package com.example.myapplication2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:53
 *@Description:
 * */


import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.bean.LoginBean;
import com.example.myapplication2.bean.RegBean;
import com.example.myapplication2.contract.LoginRegisterContract;

public class LoginRegPresenter extends BasePresenter {
    private LoginRegisterContract.IModel iModel;
    @Override
    protected void initModel() {
        iModel=new LoginRegModel();
    }

    @Override
    public void getDataLogin(String phone, String pwd) {
        iModel.getDataLogin(phone, pwd, new LoginRegisterContract.MyCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginError(Throwable throwable) {
                getView().onLoginError(throwable);
            }

            @Override
            public void onRegSuccess(RegBean regBean) {
                getView().onRegSuccess(regBean);
            }

            @Override
            public void onRegError(Throwable throwable) {
                getView().onRegError(throwable);
            }
        });
    }

    @Override
    public void getDataReg(String phone, String pwd) {
        iModel.getDataReg(phone, pwd, new LoginRegisterContract.MyCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginError(Throwable throwable) {
                getView().onLoginError(throwable);
            }

            @Override
            public void onRegSuccess(RegBean regBean) {
                getView().onRegSuccess(regBean);
            }

            @Override
            public void onRegError(Throwable throwable) {
                getView().onRegError(throwable);
            }
        });
    }
}
