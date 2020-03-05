package com.bawei.gujianlong20200224;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.gujianlong20200224.base.BaseActivity;
import com.bawei.gujianlong20200224.base.BasePresenter;
import com.bawei.gujianlong20200224.bean.UserBean;
import com.bawei.gujianlong20200224.bean.UserTwoBean;
import com.bawei.gujianlong20200224.fragment.UserFragment;
import com.bawei.gujianlong20200224.fragment.UserTwoFragment;
import com.bawei.gujianlong20200224.mvp.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tb)
    TabLayout tb;
    @BindView(R.id.vp)
    ViewPager vp;
    List<String> add = new ArrayList<>();
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void startDing() {
        add.add("我收到的礼物");
        add.add("我送出的礼物");
        UserFragment userFragment = new UserFragment();
        UserTwoFragment userTwoFragment = new UserTwoFragment();
        list.add(userFragment);
        list.add(userTwoFragment);

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
        tb.setupWithViewPager(vp);
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
    public void onUserSuccess(UserBean userBean) {

    }

    @Override
    public void onUserErrey(Throwable throwable) {

    }

    @Override
    public void onUserTwoSuccess(UserTwoBean userTwoBean) {

    }

    @Override
    public void onUserTwoErrey(Throwable throwable) {

    }

}
