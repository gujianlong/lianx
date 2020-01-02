package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:00
 *@Description:
 * */


import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.contract.Contract;

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
