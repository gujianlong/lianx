package com.example.lianxi.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/15
 *@Time:14:41
 *@Description:
 * */


import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfoPramars(String url, Class cls, Map<String, Object> map) {
        iModel.getInfoPramars(url, cls, map, new Contract.MyCallBack() {
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
    public void postInfoPramars(String url, Class cls, Map<String, Object> map) {
        iModel.postInfoPramars(url, cls, map, new Contract.MyCallBack() {
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
