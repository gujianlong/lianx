package com.example.zuoye1;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zuoye1.adapter.CartAdapter;
import com.example.zuoye1.base.BaseActivity;
import com.example.zuoye1.base.BasePresenter;
import com.example.zuoye1.bean.CartBean;
import com.example.zuoye1.bean.LoginBean;
import com.example.zuoye1.bean.RegisterBean;
import com.example.zuoye1.mvp.Presenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.ev)
    ExpandableListView ev;
    @BindView(R.id.check)
    CheckBox check;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.sl)
    SmartRefreshLayout sl;
    private CartAdapter cartAdapter;
    private List<CartBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void startDing() {
        String key = getIntent().getStringExtra("key");
        Glide.with(this).load(key)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(image);
        mPresenter.postInfoCart();
    }

    @Override
    protected void initView() {
        sl.setEnableLoadMore(true);
        sl.setEnableRefresh(true);
        sl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                mPresenter.postInfoCart();
                sl.finishRefresh();
            }
        });

        sl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.postInfoCart();

                sl.finishLoadMore();

            }
        });

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
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginError(Throwable throwable) {

    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {

    }

    @Override
    public void onRegisterError(Throwable throwable) {

    }

    @Override
    public void onCartSuccess(CartBean cartBean) {
        List<CartBean.ResultBean> result = cartBean.getResult();
        list.addAll(result);
        cartAdapter = new CartAdapter(list, this);
        ev.setAdapter(cartAdapter);
        cartAdapter.setItemClick(new CartAdapter.ItemClick() {
            @Override
            public void onClick() {
                price.setText("" + cartAdapter.contentTouchPrice());
                boolean b = cartAdapter.calculateTouchIsChecked();
                check.setChecked(b);
            }
        });
        for (int i = 0; i < result.size(); i++) {
            ev.expandGroup(i);
        }

        cartAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCartError(Throwable throwable) {

    }

    @OnClick(R.id.check)
    public void onViewClicked() {
        boolean b = cartAdapter.calculateTouchIsChecked();
        b = !b;
        cartAdapter.IsChecked(b);
        price.setText("" + cartAdapter.contentTouchPrice());
    }

}
