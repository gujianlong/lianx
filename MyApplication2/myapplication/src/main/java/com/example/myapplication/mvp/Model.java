package com.example.myapplication.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:59
 *@Description:
 * */


import com.example.myapplication.contract.Contract;
import com.example.myapplication.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {

    @Override
    public void getInfo(String url, Class cls, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getInfo(url, cls, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                myCallBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }

    @Override
    public void postInfo(String url, Class cls, final Map<String, Object> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().postInfo(url, cls, map, new NetUtils.NetCallBack() {
            @Override
            public void onSuccess(Object o) {
                myCallBack.onSuccess(o);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
