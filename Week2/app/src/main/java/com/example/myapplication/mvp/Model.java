package com.example.myapplication.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:14:06
 *@Description:
 * */


import com.example.myapplication.contract.Contract;
import com.example.myapplication.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getJsonGet(url, new NetUtils.NetCallBack() {
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
