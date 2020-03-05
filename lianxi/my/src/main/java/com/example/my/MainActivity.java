package com.example.my;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.my.fragment.BlankFragment;
import com.example.my.fragment.BlankFragment2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager vp;
    private DrawerLayout drawer_layout;
    private ActionBarDrawerToggle toggle;
    List<Fragment> list=new ArrayList<>();
    List<String> add=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initionBer();
    }

    private void initionBer() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close);
        toggle.syncState();
        drawer_layout.addDrawerListener(toggle);

        add.add("首页");
        add.add("我的");

        list.add(new BlankFragment());
        list.add(new BlankFragment2());
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
        tab_layout.setupWithViewPager(vp);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        vp = (ViewPager) findViewById(R.id.vp);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
}
