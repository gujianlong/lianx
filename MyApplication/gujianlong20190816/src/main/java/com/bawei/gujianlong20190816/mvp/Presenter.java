package com.bawei.gujianlong20190816.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:51
 *@Description:
 * */


import com.bawei.gujianlong20190816.base.BasePresenter;
import com.bawei.gujianlong20190816.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void onGetInfo(String url, Class cls, Map<String, Object> map) {
        iModel.onGetInfo(url, cls, map, new Contract.MyCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void onPostInfo(String url, Class cls, Map<String, Object> map) {
        iModel.onPostInfo(url, cls, map, new Contract.MyCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
