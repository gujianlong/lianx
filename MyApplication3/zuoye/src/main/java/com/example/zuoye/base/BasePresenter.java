package com.example.gujianlong221.base;
/*
 *@auther:谷建龙
 *@Date: 2020/2/26
 *@Time:16:53
 *@Description:
 * */


import com.example.gujianlong221.contract.LoginRegisterContract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends LoginRegisterContract.IView> implements LoginRegisterContract.IPresenter {

    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onAttch(V v) {
        mWeak = new WeakReference<>(v);
    }

    protected void onDeAttch() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
    }

    protected V getView() {
        return mWeak.get();
    }
}
