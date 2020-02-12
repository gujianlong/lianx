package com.example.zuoye3;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zuoye3.adapter.MyAdapter;
import com.example.zuoye3.base.BaseActivity;
import com.example.zuoye3.base.BasePresenter;
import com.example.zuoye3.bean.OrderBean;
import com.example.zuoye3.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends BaseActivity {

    private List<OrderBean.OrderListBean> list = new ArrayList<>();

    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;
    private int count = 5;
    private MyAdapter myAdapter;

    @Override
    protected void startDing() {
        mPresenter.getInfo(status, page, count);
        myAdapter = new MyAdapter(this, list);
        rv.setAdapter(myAdapter);
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void SuccessionOrder(OrderBean orderBean) {
        list.addAll(orderBean.getOrderList());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void ErrorOrder(Throwable throwable) {

    }

}
