package com.example.gujianlong1230;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong1230.adabter.DingAdapter;
import com.example.gujianlong1230.adabter.MyAdapter;
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

public class DingdanActivity extends BaseActivity {


    @BindView(R.id.rv)
    RecyclerView rv;
    private List<DingBean.ResultBean> list = new ArrayList<>();
    private DingAdapter dingAdapter;

    @Override
    protected void startDing() {
        mPresenter.getInfoParamDing();
        dingAdapter = new DingAdapter(this, list);
        rv.setAdapter(dingAdapter);
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
        return R.layout.activity_dingdan;
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
        list.addAll(dingBean.getResult());
        dingAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDingError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }

}
