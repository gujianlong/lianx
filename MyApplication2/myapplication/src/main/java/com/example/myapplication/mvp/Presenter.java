package com.example.myapplication.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:00
 *@Description:
 * */


import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contract.Contract;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;


    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void getInfo(String url, Class cls) {
        iModel.getInfo(url, cls, new Contract.MyCallBack() {
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
    public void postInfo(String url, Class cls, Map<String, Object> map) {
        iModel.postInfo(url, cls, map, new Contract.MyCallBack() {
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
