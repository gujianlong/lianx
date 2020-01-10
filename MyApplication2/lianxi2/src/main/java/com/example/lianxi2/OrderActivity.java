package com.example.lianxi2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.OrderBean;
import com.example.lianxi2.bean.UserBean;
import com.example.lianxi2.fragment.OrderFragment;
import com.example.lianxi2.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void startDing() {
        OrderFragment instance = OrderFragment.getInstance(0);
        OrderFragment instance1 = OrderFragment.getInstance(1);
        OrderFragment instance2 = OrderFragment.getInstance(2);
        OrderFragment instance3 = OrderFragment.getInstance(3);
        OrderFragment instance9 = OrderFragment.getInstance(9);
        list.add(instance);
        list.add(instance1);
        list.add(instance2);
        list.add(instance3);
        list.add(instance9);
        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

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
    public void onClassSuccess(UserBean homeBean) {

    }

    @Override
    public void onClassError(Throwable throwable) {

    }

    @Override
    public void onOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void onOrderError(Throwable throwable) {

    }


}
