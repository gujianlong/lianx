package com.example.lianxi2.base;
/*
 *@auther:谷建龙
 *@Date: 2019/12/18
 *@Time:19:56
 *@Description:
 * */


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lianxi2.contract.Contract;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.IView {
    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layputId(), container, false);
        initView(inflate);
        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.onAttch(this);
        }
        return inflate;
    }

    protected abstract P getPresenter();

    protected abstract void initView(View inflate);

    protected abstract int layputId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startDing();
    }

    protected abstract void startDing();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttch();
        }
    }
}
