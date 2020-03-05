package com.example.lianxi2.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/14
 *@Time:15:00
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.adapter.OrderAdapter;
import com.example.lianxi2.base.BaseFragment;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.mvp.Presenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.mSmart)
    SmartRefreshLayout mSmart;
    private int status = 0;
    private int page = 1;
    List<OrderBean.OrderListBean> list = new ArrayList<>();
    private OrderAdapter orderAdapter;

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mSmart.setEnableRefresh(true);
        mSmart.setEnableLoadMore(true);
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                page = 1;
                mPresenter.getDataOrder(27909, "158176549198327909", status, page, 5);
                mSmart.finishRefresh();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getDataOrder(27909, "158176549198327909", status, page, 5);
                mSmart.finishLoadMore();
            }
        });
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
        mPresenter.getDataOrder(27909, "158176549198327909", status, page, 5);
        orderAdapter = new OrderAdapter(list, getContext());
        rv.setAdapter(orderAdapter);
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

    }

    @Override
    public void onLoginError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {
        list.addAll(orderBean.getOrderList());
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
