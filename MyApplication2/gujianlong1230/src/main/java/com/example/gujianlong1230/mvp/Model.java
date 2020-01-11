package com.example.gujianlong1230.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:59
 *@Description:
 * */


import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.contract.Contract;
import com.example.gujianlong1230.utils.NetUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {


    @Override
    public void getInfoBanner(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        myCallBack.onBannerSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onBannerError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfo(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoNot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        myCallBack.onHomeSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onHomeError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfoParam(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParam("11357", "157870443494711357")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        myCallBack.onCartSuccess(cartBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onCartError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfoParamDing(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParamDing("11357", "157870443494711357")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DingBean dingBean) {
                        myCallBack.onDingSuccess(dingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onDingError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfoParamOrder(int status, int page, int count, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParamOrder("11357", "157870443494711357", status, page, count)
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
