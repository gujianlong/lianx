package com.example.myapplication.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:14:07
 *@Description:
 * */


import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.Contract;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfo(String url) {
        iModel.getInfo(url, new Contract.MyCallBack() {
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
