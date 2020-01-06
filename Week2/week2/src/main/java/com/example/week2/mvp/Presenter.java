package com.example.week2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:10:01
 *@Description:
 * */


import com.example.week2.base.BasePresenter;
import com.example.week2.bean.ItemBean;
import com.example.week2.bean.UserBean;
import com.example.week2.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfoNo() {
        iModel.getInfoNo(new Contract.MyCallBack() {
            @Override
            public void onCalssSuccess(UserBean userBean) {
                getView().onCalssSuccess(userBean);
            }

            @Override
            public void onCalssError(Throwable throwable) {
                getView().onCalssError(throwable);
            }

            @Override
            public void onCommitSuccess(ItemBean itemBean) {
                getView().onCommitSuccess(itemBean);
            }

            @Override
            public void onCommitError(Throwable throwable) {
                getView().onCommitError(throwable);
            }
        });
    }

    @Override
    public void getInfoParams(String stringId) {
        iModel.getInfoParams(stringId, new Contract.MyCallBack() {
            @Override
            public void onCalssSuccess(UserBean userBean) {
                getView().onCalssSuccess(userBean);
            }

            @Override
            public void onCalssError(Throwable throwable) {
                getView().onCalssError(throwable);
            }

            @Override
            public void onCommitSuccess(ItemBean itemBean) {
                getView().onCommitSuccess(itemBean);
            }

            @Override
            public void onCommitError(Throwable throwable) {
                getView().onCommitError(throwable);
            }
        });
    }
}
