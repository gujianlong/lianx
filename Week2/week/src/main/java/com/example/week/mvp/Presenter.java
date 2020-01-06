package com.example.week.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:00
 *@Description:
 * */

import com.example.week.base.BasePresenter;
import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;
import com.example.week.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }


    @Override
    public void getInfo() {
        iModel.getInfo(new Contract.MyCallBack() {
            @Override
            public void onClassSuccess(UserBean url) {
                getView().onClassSuccess(url);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
            }

            @Override
            public void onCommitSuccess(ItemBean url) {
                getView().onCommitSuccess(url);
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
            public void onClassSuccess(UserBean url) {
                getView().onClassSuccess(url);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
            }

            @Override
            public void onCommitSuccess(ItemBean url) {
                getView().onCommitSuccess(url);
            }

            @Override
            public void onCommitError(Throwable throwable) {
                getView().onCommitError(throwable);
            }
        });
    }
}
