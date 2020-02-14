package com.example.lianxi2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.LoginBean;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.RegBean;
import com.example.lianxi2.fragment.OrderFragment;
import com.example.lianxi2.mvp.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    List<String> add = new ArrayList<>();
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void startDing() {
        add.add("全部订单");
        add.add("代付款");
        add.add("待收货");
        add.add("待评价");
        add.add("已完成");

        OrderFragment orderFragment0 = OrderFragment.getInstance(0);
        OrderFragment orderFragment1 = OrderFragment.getInstance(1);
        OrderFragment orderFragment2 = OrderFragment.getInstance(2);
        OrderFragment orderFragment3 = OrderFragment.getInstance(3);
        OrderFragment orderFragment9 = OrderFragment.getInstance(9);
        list.add(orderFragment0);
        list.add(orderFragment1);
        list.add(orderFragment2);
        list.add(orderFragment3);
        list.add(orderFragment9);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return add.get(position);
            }
        });
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_order;
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

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }
}
