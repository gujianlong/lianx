package com.example.zuoye.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/13
 *@Time:14:29
 *@Description:
 * */



import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.contract.Contract;
import com.example.zuoye.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {

    @Override
    public void getDataOne(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataOne()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeingBean beingBean) {
                        myCallBack.onOneSuccess(beingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onOneError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataTwo(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataTwo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TwoBean twoBean) {
                        myCallBack.onTwoinSuccess(twoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onTwoinError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
