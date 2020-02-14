package com.example.myorder;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myorder.base.BaseActivity;
import com.example.myorder.base.BasePresenter;
import com.example.myorder.bean.OrderBean;
import com.example.myorder.fragment.OrderFragment;
import com.example.myorder.mvp.Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<Fragment> list = new ArrayList<>();


    @Override
    protected void startDing() {
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
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.button01:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.button02:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.button03:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.button04:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.button05:
                        vp.setCurrentItem(4);
                        break;
                }
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
        return R.layout.activity_main;
    }

    @Override
    public void getOrderSuccess(OrderBean orderBean) {

    }

    @Override
    public void getOrderError(Throwable throwable) {

    }
}
