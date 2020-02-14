package com.example.week3.base;
/*
 *@auther:谷建龙
 *@Date: 2020/1/11
 *@Time:11:02
 *@Description:
 * */


import com.example.week3.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.IVew> implements Contract.IPresenter {
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
