package com.bawei.gujianlong20191231.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/31
 *@Time:9:14
 *@Description:
 * */


import com.bawei.gujianlong20191231.contract.Contract;
import com.bawei.gujianlong20191231.utils.NetUtils;

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
