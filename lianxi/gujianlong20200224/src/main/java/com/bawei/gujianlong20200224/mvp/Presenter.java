package com.bawei.gujianlong20200224.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:46
 *@Description:
 * */


import com.bawei.gujianlong20200224.base.BasePresenter;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.contract.Contract;

public class Presenter extends BasePresenter {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }


    @Override
    public void getDataUser(int userId, String sessionId, int type, int page, int size) {
        model.getDataUser(userId, sessionId, type, page, size, new Contract.MyCallBack() {
            @Override
            public void onUserSuccess(UserBean userBean) {
                getView().onUserSuccess(userBean);
            }

            @Override
            public void onUserErrey(Throwable throwable) {
                getView().onUserErrey(throwable);
            }

            @Override
            public void onUserTwoSuccess(UserTwoBean userTwoBean) {
                getView().onUserTwoSuccess(userTwoBean);
            }

            @Override
            public void onUserTwoErrey(Throwable throwable) {
                getView().onUserTwoErrey(throwable);
            }
        });
    }

    @Override
    public void getDataUserTwo(int userId, String sessionId, int type, int page, int size) {
        model.getDataUserTwo(userId, sessionId, type, page, size, new Contract.MyCallBack() {
            @Override
            public void onUserSuccess(UserBean userBean) {
                getView().onUserSuccess(userBean);
            }

            @Override
            public void onUserErrey(Throwable throwable) {
                getView().onUserErrey(throwable);
            }

            @Override
            public void onUserTwoSuccess(UserTwoBean userTwoBean) {
                getView().onUserTwoSuccess(userTwoBean);
            }

            @Override
            public void onUserTwoErrey(Throwable throwable) {
                getView().onUserTwoErrey(throwable);
            }
        });
    }
}
