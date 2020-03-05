package com.bawei.gujianlong2020218.fragment;
/*
 *@auther:谷建龙
 *@Date: 2020/2/18
 *@Time:10:30
 *@Description:
 * */


import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.gujianlong2020218.R;
import com.bawei.gujianlong2020218.base.BaseFragment;
import com.bawei.gujianlong2020218.base.BasePresenter;
import com.bawei.gujianlong2020218.bean.OrderBean;
import com.bawei.gujianlong2020218.bean.ShowBean;
import com.bawei.gujianlong2020218.mvp.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderFragment extends BaseFragment {
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> list = new ArrayList<>();
    List<String> add = new ArrayList<>();


    @Override
    protected void initView(View inflate) {

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
        add.add("全部订单");
        add.add("代付款");
        add.add("待收货");
        add.add("待评价");
        add.add("已完成");

        OrderfromFragment instance0 = OrderfromFragment.getInstance(0);
        OrderfromFragment instance1 = OrderfromFragment.getInstance(1);
        OrderfromFragment instance2 = OrderfromFragment.getInstance(2);
        OrderfromFragment instance3 = OrderfromFragment.getInstance(3);
        OrderfromFragment instance9 = OrderfromFragment.getInstance(9);

        list.add(instance0);
        list.add(instance1);
        list.add(instance2);
        list.add(instance3);
        list.add(instance9);
        vp.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
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
        tl.setupWithViewPager(vp);
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
