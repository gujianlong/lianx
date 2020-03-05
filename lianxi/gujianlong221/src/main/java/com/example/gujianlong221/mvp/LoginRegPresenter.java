package com.example.gujianlong221.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:53
 *@Description:
 * */


import com.example.gujianlong221.base.BasePresenter;
import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.bean.UserBean;
import com.example.gujianlong221.contract.LoginRegisterContract;

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

            @Override
            public void onUserSuccess(UserBean userBean) {
                getView().onUserSuccess(userBean);
            }

            @Override
            public void onUserError(Throwable throwable) {
                getView().onUserError(throwable);
            }
        });
    }

    @Override
    public void getDataUser() {
        iModel.getDataUser(new LoginRegisterContract.MyCallBack() {
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

            @Override
            public void onUserSuccess(UserBean userBean) {
                getView().onUserSuccess(userBean);
            }

            @Override
            public void onUserError(Throwable throwable) {
                getView().onUserError(throwable);
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

            @Override
            public void onUserSuccess(UserBean userBean) {
                getView().onUserSuccess(userBean);
            }

            @Override
            public void onUserError(Throwable throwable) {
                getView().onUserError(throwable);
            }
        });
    }
}
