package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:19:47
 *@Description:
 * */


import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {
    @Override
    public void getInfoNotParams(String url, Class cls, final Contract.MyCallBack myCallBack) {
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
    public void postInfoParams(String url, Class cls, Map<String, Object> map, final Contract.MyCallBack myCallBack) {
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
