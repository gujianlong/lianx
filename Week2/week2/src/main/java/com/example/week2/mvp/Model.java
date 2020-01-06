package com.example.week2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/4
 *@Time:9:58
 *@Description:
 * */


import com.example.week2.bean.ItemBean;
import com.example.week2.bean.UserBean;
import com.example.week2.contract.Contract;
import com.example.week2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getInfoNo(final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoNo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        myCallBack.onCalssSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onCalssError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getInfoParams(String stringId, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParams(stringId, 1, 10)
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
