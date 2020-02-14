package com.example.lianxi.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/15
 *@Time:14:38
 *@Description:
 * */


import android.content.Context;

import com.example.lianxi.contract.Contract;
import com.example.lianxi.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {
    @Override
    public void getInfoPramars(String url, Class cls, Map<String, Object> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getInfo(url, map, cls, new NetUtils.NetCallBack() {
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
    public void postInfoPramars(String url, Class cls, final Map<String, Object> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().postInfo(url, map, cls, new NetUtils.NetCallBack() {
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
