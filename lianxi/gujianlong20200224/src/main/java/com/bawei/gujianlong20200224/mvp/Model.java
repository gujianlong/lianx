package com.bawei.gujianlong20200224.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:45
 *@Description:
 * */


import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.contract.Contract;
import com.bawei.gujianlong20200224.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getDataUser(int userId, String sessionId, int type, int page, int size, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataUser(userId, sessionId, type, page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        myCallBack.onUserSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onUserErrey(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataUserTwo(int userId, String sessionId, int type, int page, int size, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataUserTwo(userId, sessionId, type, page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserTwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserTwoBean userTwoBean) {
                        myCallBack.onUserTwoSuccess(userTwoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onUserTwoErrey(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
