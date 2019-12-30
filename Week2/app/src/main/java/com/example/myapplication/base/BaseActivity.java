package com.example.myapplication.base;
/*
 *@auther:谷建龙
 *@Date: 2019/12/30
 *@Time:14:11
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.contract.Contract;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            CodeUtils.init(this);
            ButterKnife.bind(this);
            mPresenter = getPresenter();
            if (mPresenter != null) {
                mPresenter.onAttch(this);
            }


            initView();
            startDing();
        }
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
