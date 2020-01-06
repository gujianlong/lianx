package com.example.gujianlong20200106.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:17
 *@Description:
 * */


import com.example.gujianlong20200106.base.BaseActivity;
import com.example.gujianlong20200106.base.BasePresenter;
import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;
import com.example.gujianlong20200106.contract.Contract;

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
            public void onClassSuccess(HomeBean homeBean) {
                getView().onClassSuccess(homeBean);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
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
    public void getInfoParams(String url) {
        iModel.getInfoParams(url, new Contract.MyCallBack() {
            @Override
            public void onClassSuccess(HomeBean homeBean) {
                getView().onClassSuccess(homeBean);
            }

            @Override
            public void onClassError(Throwable throwable) {
                getView().onClassError(throwable);
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
