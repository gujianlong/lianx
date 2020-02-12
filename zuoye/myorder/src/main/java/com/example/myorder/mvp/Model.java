package com.example.myorder.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:39
 *@Description:
 * */


import android.app.Application;

import com.example.myorder.bean.OrderBean;
import com.example.myorder.contract.Contract;
import com.example.myorder.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getOrderData(int userId, String sessionId, int status, int page, int count, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getOrderData(userId, sessionId, status, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderBean orderBean) {
                        if ("0000".equals(orderBean.getStatus())) {
                            myCallBack.getOrderSuccess(orderBean);
                        } else {
                            myCallBack.getOrderError(new Exception(orderBean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.getOrderError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
