package com.example.zuoye;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.zuoye.base.BaseActivity;
import com.example.zuoye.base.BasePresenter;
import com.example.zuoye.bean.BeingBean;
import com.example.zuoye.bean.TwoBean;
import com.example.zuoye.fragment.BeingFragment;
import com.example.zuoye.fragment.SoonFragment;
import com.example.zuoye.mvp.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tb)
    TabLayout tb;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> list = new ArrayList<>();
    List<String> add = new ArrayList<>();


    @Override
    protected void startDing() {
        add.add("正在上映");
        add.add("即将上映");
        BeingFragment beingFragment = new BeingFragment();
        SoonFragment soonFragment = new SoonFragment();
        list.add(beingFragment);
        list.add(soonFragment);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
    public void onOneSuccess(BeingBean beingBean) {

    }

    @Override
    public void onOneError(Throwable throwable) {

    }

    @Override
    public void onTwoinSuccess(TwoBean twoBean) {

    }

    @Override
    public void onTwoinError(Throwable throwable) {

    }

}
