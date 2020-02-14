package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:19:59
 *@Description:
 * */


import com.example.lianxi2.R;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;


    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfoNotParams(String url, Class cls) {
        iModel.getInfoNotParams(url, cls, new Contract.MyCallBack() {
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
    public void postInfoParams(String url, Class cls, Map<String, Object> map) {
        iModel.postInfoParams(url, cls, map, new Contract.MyCallBack() {
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
