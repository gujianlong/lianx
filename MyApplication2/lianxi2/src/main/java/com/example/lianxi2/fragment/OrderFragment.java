package com.example.lianxi2.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/1/9
 *@Time:15:33
 *@Description:
 * */


import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi2.R;
import com.example.lianxi2.adapter.OrderAdapter;
import com.example.lianxi2.base.BaseFragment;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;
    private int count = 5;
    private List<OrderBean.OrderListBean> list = new ArrayList<>();
    private OrderAdapter orderAdapter;

    public static OrderFragment getInstance(int voller) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", voller);
        orderFragment.setArguments(bundle);
        return orderFragment;
    }

    @Override
    protected void initView(View inflate) {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.order_fragment;
    }

    @Override
    protected void startDing() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            status = arguments.getInt("key");
        }
        mPresenter.getInfoParamsOrser(count, page, status);
        orderAdapter = new OrderAdapter(getActivity(), list);
        rv.setAdapter(orderAdapter);
    }

    @Override
    public void onClassSuccess(UserBean homeBean) {

    }

    @Override
    public void onClassError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {
        list.clear();
        list.addAll(orderBean.getOrderList());
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
