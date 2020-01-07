package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:59
 *@Description:
 * */


import com.example.gujianlong1230.contract.Contract;
import com.example.gujianlong1230.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {

    @Override
    public void getInfo(String url, Class cls, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getJsonGet(url, cls, new NetUtils.NetCallBack() {
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
    public void getInfoParam(String url, Map<String, Object> map, Class cls, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getJsonGetParams(url, map, cls, new NetUtils.NetCallBack() {
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
