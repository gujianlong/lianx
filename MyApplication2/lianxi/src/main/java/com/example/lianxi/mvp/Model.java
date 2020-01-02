package com.example.lianxi.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/28
 *@Time:13:48
 *@Description:
 * */


import com.example.lianxi.contract.Contract;
import com.example.lianxi.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInfoParams(String url, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getInfo(url, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(String url) {
                myCallBack.onSuccess(url);
            }

            @Override
            public void onError(Throwable throwable) {
                myCallBack.onError(throwable);
            }
        });
    }
}
