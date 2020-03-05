package com.bawei.gujianlong2020218.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:10:01
 *@Description:
 * */


import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.contract.Contract;
import com.bawei.gujianlong2020218.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getShowData(String keyword, int page, int count, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getShowData(keyword, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        myCallBack.onShowSuccess(showBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onShowError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

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
                        myCallBack.onOrderSuccess(orderBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onOrderError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
