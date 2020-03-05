package com.bawei.gujianlong2020218;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.gujianlong2020218.base.BaseActivity;
import com.bawei.gujianlong2020218.base.BasePresenter;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.fragment.OrderFragment;
import com.bawei.gujianlong2020218.fragment.ShowFragment;
import com.bawei.gujianlong2020218.mvp.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.a_vp)
    ViewPager aVp;
    @BindView(R.id.a_tl)
    TabLayout aTl;
    List<String> add = new ArrayList<>();
    List<Fragment> list = new ArrayList<>();


    @Override
    protected void startDing() {
        add.add("首页");
        add.add("订单");
        ShowFragment showFragment = new ShowFragment();
        OrderFragment orderFragment = new OrderFragment();
        list.add(showFragment);
        list.add(orderFragment);
        //设置适配器
        aVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        aTl.setupWithViewPager(aVp);
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
        return R.layout.activity_main;
    }

    @Override
    public void onShowSuccess(ShowBean showBean) {

    }

    @Override
    public void onShowError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }

}
