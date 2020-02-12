package com.example.zuoye1.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/1/15
 *@Time:10:44
 *@Description:
 * */


import com.example.zuoye1.bean.CartBean;
import com.example.zuoye1.bean.LoginBean;
import com.example.zuoye1.bean.RegisterBean;
import com.example.zuoye1.contract.Contract;
import com.example.zuoye1.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void postInfoLogin(String phone, String pwd, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().postInfoLogin(phone,pwd)
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
    public void postInfoRegister(String phone, String pwd, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().postInfoRegister(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        myCallBack.onRegisterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.onRegisterError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void postInfoCart(Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiService().getInfoCart("27909","157905899311027909")
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
}
