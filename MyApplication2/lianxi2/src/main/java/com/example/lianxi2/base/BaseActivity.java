package com.example.lianxi2.base;
/*
 *@auther:谷建龙
 *@Date: 2020/1/6
 *@Time:9:20
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lianxi2.contract.Contract;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.onAttch(this);
        }
        ButterKnife.bind(this);
        initView();
        startDing();
    }

    protected abstract void startDing();

    protected abstract void initView();

    protected abstract P getPresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttch();
        }
    }
}
