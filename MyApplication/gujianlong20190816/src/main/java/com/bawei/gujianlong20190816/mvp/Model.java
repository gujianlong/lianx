package com.bawei.gujianlong20190816.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/16
 *@Time:9:48
 *@Description:
 * */


import com.bawei.gujianlong20190816.contract.Contract;
import com.bawei.gujianlong20190816.utils.NetUtils;

import java.util.Map;
import java.util.ResourceBundle;

public class Model implements Contract.IModel {
    @Override
    public void onGetInfo(String url, Class cls, Map<String, Object> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getInfo(url, cls, map, new NetUtils.NetCallBack() {
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
