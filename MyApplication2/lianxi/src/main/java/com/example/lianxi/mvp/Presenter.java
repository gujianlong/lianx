package com.example.lianxi.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/28
 *@Time:13:49
 *@Description:
 * */


import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfoParams(String url) {
        iModel.getInfoParams(url, new Contract.MyCallBack() {
            @Override
            public void onSuccess(String url) {
                getView().onSuccess(url);
            }

            @Override
            public void onError(Throwable throwable) {
                getView().onError(throwable);
            }
        });
    }
}
