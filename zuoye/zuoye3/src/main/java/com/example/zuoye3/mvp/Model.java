package com.example.zuoye3.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:15:29
 *@Description:
 * */


import com.example.zuoye3.bean.OrderBean;
import com.example.zuoye3.contract.Contract;
import com.example.zuoye3.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getInfo(int status, int page, int count, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfo("27909","157967714814327909",status,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderBean orderBean) {
                        myCallBack.SuccessionOrder(orderBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.ErrorOrder(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
