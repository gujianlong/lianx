package com.bawei.gujianlong20191231.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:9:15
 *@Description:
 * */


import com.bawei.gujianlong20191231.base.BasePresenter;
import com.bawei.gujianlong20191231.contract.Contract;

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
