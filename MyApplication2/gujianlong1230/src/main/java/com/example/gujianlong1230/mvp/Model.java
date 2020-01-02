package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:59
 *@Description:
 * */


import com.example.gujianlong1230.contract.Contract;
import com.example.gujianlong1230.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, final Contract.MyCallBack myCallBack) {
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
