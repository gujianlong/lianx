package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:29
 *@Description:
 * */


import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getReg(String phone, String pwd, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getReg(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        myCallBack.onRegSuccess(regBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onRegError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLogin(String phone, String pwd, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getLogin(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        myCallBack.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onLoginError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataOrder(int userId, String sessionId, int status, int page, int count, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataOrder(userId,sessionId,status,page,count)
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
