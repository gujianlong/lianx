package com.example.gujianlong221.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:48
 *@Description:
 * */


import com.example.gujianlong221.bean.LoginBean;
import com.example.gujianlong221.bean.RegBean;
import com.example.gujianlong221.contract.LoginRegisterContract;
import com.example.gujianlong221.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginRegModel implements LoginRegisterContract.IModel {
    @Override
    public void getDataLogin(String phone, String pwd, LoginRegisterContract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataLogin(phone,pwd)
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
    public void getDataReg(String phone, String pwd, LoginRegisterContract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getDataReg(phone,pwd)
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
}
