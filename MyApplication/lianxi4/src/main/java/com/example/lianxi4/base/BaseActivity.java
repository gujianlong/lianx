package com.example.lianxi4.base;
/*
 *@auther:谷建龙
 *@Date: 2019/12/23
 *@Time:10:28
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lianxi4.contract.Contract;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId()!=0){
            setContentView(layoutId());
            initView();
            mPresenter=getPresenter();
            if (mPresenter != null) {
                mPresenter.onAttch(this);
            }
            startDing();
        }
    }

    protected abstract void startDing();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttch();
        }
    }
}
