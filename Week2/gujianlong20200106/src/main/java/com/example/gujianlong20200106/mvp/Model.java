package com.example.gujianlong20200106.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:14
 *@Description:
 * */


import com.example.gujianlong20200106.bean.HomeBean;
import com.example.gujianlong20200106.bean.ItemBean;
import com.example.gujianlong20200106.contract.Contract;
import com.example.gujianlong20200106.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getInfoNo(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoNo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        myCallBack.onClassSuccess(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onClassError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfoParams(String url, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParams("url")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ItemBean itemBean) {
                        myCallBack.onCommitSuccess(itemBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onCommitError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
