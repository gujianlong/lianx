package com.example.week.mvp;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:8:59
 *@Description:
 * */


import com.example.week.bean.ItemBean;
import com.example.week.bean.UserBean;
import com.example.week.contract.Contract;
import com.example.week.utils.NetUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {


    @Override
    public void getInfo(final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoNo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        myCallBack.onClassSuccess(userBean);
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
    public void getInfoParams(String url, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParams(url, 1, 10)
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
