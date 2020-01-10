package com.example.gujianlong1230;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1230.adabter.OrderAdapter;
import com.example.gujianlong1230.base.BaseActivity;
import com.example.gujianlong1230.base.BasePresenter;
import com.example.gujianlong1230.bean.BannerBean;
import com.example.gujianlong1230.bean.CartBean;
import com.example.gujianlong1230.bean.DingBean;
import com.example.gujianlong1230.bean.OrderBean;
import com.example.gujianlong1230.bean.UserBean;
import com.example.gujianlong1230.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {
    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;
    private int count = 5;
    private List<OrderBean.OrderListBean> list = new ArrayList<>();
    private OrderAdapter orderAdapter;


    @Override
    protected void startDing() {
        mPresenter.getInfoParamOrder(status, page, count);
        orderAdapter = new OrderAdapter(this, list);
        rv.setAdapter(orderAdapter);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void onHomeSuccess(UserBean userBean) {

    }

    @Override
    public void onHomeError(Throwable throwable) {

    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

    }

    @Override
    public void onBannerError(Throwable throwable) {

    }

    @Override
    public void onCartSuccess(CartBean cartBean) {

    }

    @Override
    public void onCartError(Throwable throwable) {

    }

    @Override
    public void onDingSuccess(DingBean dingBean) {

    }

    @Override
    public void onDingError(Throwable throwable) {

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
