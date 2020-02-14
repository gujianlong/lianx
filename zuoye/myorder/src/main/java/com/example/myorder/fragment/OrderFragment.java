package com.example.myorder.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:56
 *@Description:
 * */


import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myorder.R;
import com.example.myorder.adapter.OrderAdapter;
import com.example.myorder.base.BaseFragment;
import com.example.myorder.base.BasePresenter;
import com.example.myorder.bean.OrderBean;
import com.example.myorder.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.logging.HttpLoggingInterceptor;

public class OrderFragment extends BaseFragment {


    @BindView(R.id.rv)
    RecyclerView rv;
    private int status=0;
    List<OrderBean.OrderListBean> list=new ArrayList<>();
    private OrderAdapter orderAdapter;

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
        return R.layout.order_frag;
    }

    @Override
    protected void startDing() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getInt("status");
        }
        mPresenter.getOrderData(27909, "158150564986027909",status, 1, 5);
        orderAdapter = new OrderAdapter(list,getContext());
        rv.setAdapter(orderAdapter);
    }
    public static OrderFragment getInstance(int status) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.getInt("status", status);
        orderFragment.setArguments(bundle);
        return orderFragment;
    }


    @Override
    public void getOrderSuccess(OrderBean orderBean) {
        list.clear();
        list.addAll(orderBean.getOrderList());
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void getOrderError(Throwable throwable) {

    }


}
