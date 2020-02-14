package com.example.lianxi2.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/14
 *@Time:15:00
 *@Description:
 * */


import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.base.BaseFragment;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.mvp.Presenter;

import butterknife.BindView;

public class OrderFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.order_frag;
    }

    @Override
    protected void startDing() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getInt("starts");
        }

        mPresenter.getDataOrder(27909, "158166721273327909", status, page, 10);
    }

    public static OrderFragment getInstance(int starts) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.getInt("starts", starts);
        orderFragment.setArguments(bundle);
        return orderFragment;
    }

    @Override
    public void onRegSuccess(RegBean regBean) {

    }

    @Override
    public void onRegError(Throwable throwable) {

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(getContext(), "a"+loginBean.getResult(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
