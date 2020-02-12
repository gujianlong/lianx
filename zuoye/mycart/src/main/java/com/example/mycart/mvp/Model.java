package com.example.mycart.mvp;
/*
 *@auther:谷建龙
 *@Date: 2020/2/5
 *@Time:15:21
 *@Description:
 * */


import com.example.mycart.bean.CartBean;
import com.example.mycart.contract.Contract;
import com.example.mycart.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model implements Contract.IModel {
    @Override
    public void getDataCart(int userId, String sessionId, Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().getApiServier().getDataCart(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        String status = cartBean.getStatus();
                       if ("0000".equals(status)){
                            myCallBack.mySuccessCart(cartBean);
                        }else {
                           myCallBack.myErrorCart(new Exception(cartBean.getMessage()));
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallBack.myErrorCart(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
