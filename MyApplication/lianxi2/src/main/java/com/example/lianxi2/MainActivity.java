package com.example.lianxi2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.fragment.HomeFragment;
import com.example.lianxi2.fragment.MyFragment;
import com.example.lianxi2.mvp.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ImageView image;
    private List<Fragment> list = new ArrayList<>();



    @Override
    protected void startDing() {

        HomeFragment homeFragment = new HomeFragment();
        list.add(homeFragment);
        MyFragment myFragment = new MyFragment();
        list.add(myFragment);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.button01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.button02:
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String error) {

    }
}
