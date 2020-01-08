package com.example.lianxi2.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:14
 *@Description:
 * */



import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {

    @Override
    public void getInfoParams(final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoParams("11357","157839537007711357")
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
}
