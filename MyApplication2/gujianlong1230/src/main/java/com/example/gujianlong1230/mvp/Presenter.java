package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:9:00
 *@Description:
 * */


import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.contract.Contract;

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
    public void getInfoParam(String url, Map<String, Object> map, Class cls) {
        iModel.getInfoParam(url, map, cls, new Contract.MyCallBack() {
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
