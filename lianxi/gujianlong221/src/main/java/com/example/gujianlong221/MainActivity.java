package com.example.gujianlong221;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.gujianlong221.fragment.CartFragment;
import com.example.gujianlong221.fragment.MyFragment;
import com.example.gujianlong221.fragment.OrderFragment;
import com.example.gujianlong221.fragment.QuanFragment;
import com.example.gujianlong221.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ShouFragment shouFragment = new ShouFragment();
        QuanFragment quanFragment = new QuanFragment();
        CartFragment cartFragment = new CartFragment();
        OrderFragment orderFragment = new OrderFragment();
        MyFragment myFragment = new MyFragment();
        list.add(shouFragment);
        list.add(quanFragment);
        list.add(cartFragment);
        list.add(orderFragment);
        list.add(myFragment);
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

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}
