package com.example.lianxi4.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/23
 *@Time:9:53
 *@Description:
 * */


import com.example.lianxi4.contract.Contract;
import com.example.lianxi4.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {
    @Override
    public void onGetInfo(String url, Class cls, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getInfoNo(url, cls, new NetUtils.NetCallBack() {
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
    public void onPostInfo(String url, Class cls, Map<String, Object> map, final Contract.MyCallBack myCallBack) {
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
